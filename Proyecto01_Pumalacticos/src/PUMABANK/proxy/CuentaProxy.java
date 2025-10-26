package PUMABANK.proxy;

// Importamos 
import PUMABANK.decorator.ICuenta;
import PUMABANK.strategy.IEstrategiaInteres;

/**
 * Proxy de Protección (Patrón Proxy).
 * Controla el acceso al objeto ICuenta real solicitando un NIP.
 * Implementa la misma interfaz que el objeto real (ICuenta).
 *
 * @author Pumalacticos
 */
public class CuentaProxy implements ICuenta {

    // Referencia al objeto "Real" (Sujeto Real)
    private ICuenta cuentaReal;
    
    // Lógica de control de acceso
    private final String nipCorrecto;
    private boolean estaAutenticado;

    /**
     * Constructor del Proxy.
     *
     * @param cuentaReal El objeto ICuenta (ya sea Cuenta o Decorador)
     * que este proxy va a proteger.
     * @param nip El NIP/contraseña requerida para operar.
     */
    public CuentaProxy(ICuenta cuentaReal, String nip) {
        this.cuentaReal = cuentaReal;
        this.nipCorrecto = nip;
        this.estaAutenticado = false; // El usuario debe loguearse primero
        System.out.println("Proxy de seguridad activado para cuenta: " + cuentaReal.getNumeroDeCuenta());
    }

    // Métodos de Control de Acceso (nuevos)
    // Estos métodos NO están en la interfaz ICuenta.
    // El cliente (App) debe conocer el Proxy para usarlos.

    /**
     * Intenta autenticar al usuario.
     * @param nipIngresado El NIP que el usuario proporciona.
     * @return true si fue exitoso, false en caso contrario.
     */
    public boolean login(String nipIngresado) {
        if (nipCorrecto.equals(nipIngresado)) {
            this.estaAutenticado = true;
            System.out.println("PROXY: Acceso Concedido.");
            return true;
        }
        System.err.println("PROXY: NIP incorrecto. Acceso Denegado.");
        this.estaAutenticado = false;
        return false;
    }

    /**
     * Cierra la sesión de seguridad.
     */
    public void logout() {
        this.estaAutenticado = false;
        System.out.println("PROXY: Sesión cerrada.");
    }

    // Métodos de ICuenta (DELEGACIÓN CON CONTROL)
    // Aquí es donde ocurre la magia del Proxy.
    // Antes de delegar, se verifica el acceso.

    /**
     * Lanza una excepción si el usuario no está autenticado.
     */
    private void verificarAcceso() throws Exception {
        if (!this.estaAutenticado) {
            throw new Exception("ACCESO DENEGADO. Se requiere autenticación (NIP).");
        }
    }

    @Override
    public void retirar(double monto){
        // Control de Acceso
        try {
            verificarAcceso();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        // Delegación (si el paso 1 fue exitoso)
        System.out.println("PROXY: Permitiendo operación 'retirar'...");
        this.cuentaReal.retirar(monto);
    }

    @Override
    public void depositar(double monto){
        // Control de Acceso
                try {
            verificarAcceso();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        // Delegación
        System.out.println("PROXY: Permitiendo operación 'depositar'...");
        this.cuentaReal.depositar(monto);
    }

    @Override
    public double getSaldo(){
        // Control de Acceso
        try {
            verificarAcceso();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
        // Delegación
        System.out.println("PROXY: Permitiendo operación 'getSaldo'...");
        return this.cuentaReal.getSaldo();
    }
    
    @Override
    public void cerrarCuenta(){
        // Control de Acceso
        try {
            verificarAcceso();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        // Delegación
        System.out.println("PROXY: Permitiendo operación 'cerrarCuenta'...");
        this.cuentaReal.cerrarCuenta();
    }

    // Métodos que NO requieren NIP (Delegación simple)
    // Decidimos que estos métodos no son "críticos" y pueden
    // ser vistos sin NIP (vemos xd)

    @Override
    public void aplicarInteres(){
        // Aplicar interés requiere NIP? , es el vemos xd.
        try {
            verificarAcceso();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("PROXY: Permitiendo operación 'aplicarInteres'...");
        this.cuentaReal.aplicarInteres();
    }
    
    @Override
    public void setEstrategiaInteres(IEstrategiaInteres nuevaEstrategia) {
        // Cambiar la estrategia requiere NIP? 
        try {
            verificarAcceso();
            System.out.println("PROXY: Permitiendo operación 'setEstrategiaInteres'...");
            this.cuentaReal.setEstrategiaInteres(nuevaEstrategia);
        } catch (Exception e) {
             System.err.println(e.getMessage());
        }
    }
    
    @Override
    public String getNumeroDeCuenta() {
        // El número de cuenta es público, no requiere NIP.
        return this.cuentaReal.getNumeroDeCuenta();
    }

    @Override
    public String getNombreCliente() {
        // El nombre del cliente es público, no requiere NIP.
        return this.cuentaReal.getNombreCliente();
    }

    @Override
    public String getDescripcion() {
        // La descripción es pública, no requiere NIP.
        return this.cuentaReal.getDescripcion();
    }
}