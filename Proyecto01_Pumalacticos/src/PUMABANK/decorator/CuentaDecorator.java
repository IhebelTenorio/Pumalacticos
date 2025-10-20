package PUMABANK.decorator;
import PUMABANK.strategy.IEstrategiaInteres;

/**
 * Decorador Abstracto.
 * Mantiene la referencia al objeto Componente (ICuenta) que envuelve.
 * Implementa la interfaz ICuenta delegando todas las llamadas al objeto envuelto.
 *
 * @author PumaLacticos
 */
public abstract class CuentaDecorator implements ICuenta {

    // El objeto que estamos "envolviendo"
    protected ICuenta cuentaEnvuelva; 

    /**
     * Constructor que recibe el objeto a envolver.
     * @param cuentaEnvuelva La instancia de ICuenta (puede ser una Cuenta u otro Decorador) a la que se añadirá funcionalidad.
     */
    public CuentaDecorator(ICuenta cuentaEnvuelva) {
        this.cuentaEnvuelva = cuentaEnvuelva;
    }

    // DELEGACIÓN DE MÉTODOS
    // Simplemente pasamos la llamada al objeto envuelto.
    // Las subclases (Decoradores Concretos) sobreescribirán los métodos donde quieran añadir lógica.

    @Override
    public void retirar(double monto) {
        this.cuentaEnvuelva.retirar(monto);
    }

    @Override
    public void depositar(double monto) {
        this.cuentaEnvuelva.depositar(monto);
    }

    @Override
    public double getSaldo() {
        return this.cuentaEnvuelva.getSaldo();
    }

    @Override
    public void cerrarCuenta() {
        this.cuentaEnvuelva.cerrarCuenta();
    }

    @Override
    public void aplicarInteres() {
        this.cuentaEnvuelva.aplicarInteres();
    }

    @Override
    public void setEstrategiaInteres(IEstrategiaInteres nuevaEstrategia) {
        this.cuentaEnvuelva.setEstrategiaInteres(nuevaEstrategia);
    }

    @Override
    public String getNumeroDeCuenta() {
        return this.cuentaEnvuelva.getNumeroDeCuenta();
    }

    @Override
    public String getNombreCliente() {
        return this.cuentaEnvuelva.getNombreCliente();
    }

    @Override
    public String getDescripcion() {
        return this.cuentaEnvuelva.getDescripcion();
    }
}