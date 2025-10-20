Guía de actualización a Java 21 (LTS)

Objetivo
- Actualizar el proyecto a Java 21 (LTS). Este repositorio parece usar compilación directa con `javac`, no hay `pom.xml` ni `build.gradle`.

Pasos recomendados
1. Instalar JDK 21
   - Windows: usar winget:
     winget install -e --id EclipseAdoptium.Temurin.21.JDK
   - O descargar desde adoptium.net u otros distribuidores.

2. Ejecutar el script de ayuda
   - PowerShell (ejecutar en la carpeta raíz del repo):
     .\scripts\setup-java21.ps1 -InstallJDK
   - O si ya instalaste JDK 21:
     .\scripts\setup-java21.ps1 -JdkPath 'C:\\Program Files\\Java\\jdk-21'

3. Compilar el proyecto
   - El script puede compilar los archivos Java si se acepta la opción interactiva.
   - Alternativamente usar javac manualmente:
     javac -d bin -source 21 -target 21 src\**\*.java

4. Ejecutar la aplicación
   - Ejecuta la clase principal (según `App.java`):
     java -cp bin PUMABANK.App

Notas y siguientes pasos
- Si usas Maven/Gradle en el futuro, añade el `pom.xml` o `build.gradle` y ajusta `maven.compiler.source` / `targetCompatibility` a 21.
- Revisa código que use APIs descontinuadas; ajusta según errores de compilación.
- Una vez compilado, corre la aplicación y tests y corrige fallos.
