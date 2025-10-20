# PowerShell script para ayudar a configurar JDK 21 en Windows y compilar el proyecto
# Requisitos: permisos para instalar software o tener choco/scoop

param(
    [switch]$InstallJDK,
    [string]$JdkPath
)

function Find-JDK21 {
    # Busca JDKs instalados en common paths
    $paths = @(
        "$env:ProgramFiles\Java",
        "$env:ProgramFiles(x86)\Java",
        "$env:USERPROFILE\jdk",
        "$env:USERPROFILE\.jdks"
    )
    foreach ($p in $paths) {
        if (Test-Path $p) {
            Get-ChildItem -Path $p -Directory -ErrorAction SilentlyContinue | Where-Object { $_.Name -match "21" }
        }
    }
}

if ($InstallJDK) {
    Write-Host "Attempting to install Eclipse Temurin JDK 21 via winget..."
    try {
        winget install -e --id EclipseAdoptium.Temurin.21.JDK || Write-Host "winget failed or not available. Please install JDK 21 manually."
    } catch {
        Write-Host "winget not available or installation failed: $_"
    }
}

if ($JdkPath) {
    if (-not (Test-Path $JdkPath)) {
        Write-Host "Provided JDK path does not exist: $JdkPath"
        exit 1
    }
    $env:JAVA_HOME = $JdkPath
    $env:Path = "$JdkPath\bin;" + $env:Path
    Write-Host "JAVA_HOME set to $JdkPath"
} else {
    $found = Find-JDK21
    if ($found) {
        Write-Host "JDK 21 candidates found:" -ForegroundColor Green
        $found | ForEach-Object { Write-Host $_.FullName }
        Write-Host "Set JAVA_HOME to one of the above paths or provide -JdkPath.
Example: .\setup-java21.ps1 -JdkPath 'C:\\Program Files\\Java\\jdk-21'"
    } else {
        Write-Host "No JDK 21 found. Run with -InstallJDK to try installing via winget, or install manually and rerun with -JdkPath." -ForegroundColor Yellow
    }
}

# Helper to compile the src folder using javac (assumes standard package layout under src)
function Compile-Project {
    $src = Join-Path $PSScriptRoot "..\src"
    $bin = Join-Path $PSScriptRoot "..\bin"
    if (-not (Test-Path $bin)) { New-Item -ItemType Directory -Path $bin | Out-Null }
    $javaFiles = Get-ChildItem -Path $src -Recurse -Include *.java | ForEach-Object { $_.FullName }
    if (-not $javaFiles) { Write-Host "No .java files found under $src"; return }
    $classpath = $bin
    $javac = "javac"
    Write-Host "Compiling ${($javaFiles).Count} Java files..."
    & $javac -d $bin -source 21 -target 21 $javaFiles
    if ($LASTEXITCODE -eq 0) {
        Write-Host "Compilation successful. Classes are in $bin" -ForegroundColor Green
    } else {
        Write-Host "Compilation failed. See javac output above." -ForegroundColor Red
    }
}

# If run interactively, offer to compile
if ($Host.UI.RawUI.KeyAvailable -or $PSVersionTable) {
    Write-Host "Would you like to attempt to compile the project now? (y/N)"
    $ans = Read-Host
    if ($ans -match '^[yY]') { Compile-Project }
}
