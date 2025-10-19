package PUMABANK.state;

// Importamos la clase Cuenta del paquete raíz 'PUMABANK'
import PUMABANK.Cuenta;

/**
 * Interfaz para el patrón de diseño State.
 * Define las operaciones que varían según el estado de la cuenta.
 * Vive en el paquete 'PUMABANK.state'.
 *
 * @author PUMALACTICOS
 */
public interface IEstadoCuenta {

    /**
     * Intenta realizar un retiro de la cuenta.
     *
     * @param cuenta El Contexto (la cuenta a modificar).
     * @param monto El monto a retirar.
     * @throws Exception Si el retiro no es posible.
     */
    void retirar(Cuenta cuenta, double monto) throws Exception;

    /**
     * Realiza un depósito en la cuenta.
     *
     * @param cuenta El Contexto (la cuenta a modificar).
     * @param monto El monto a depositar.
     * @throws Exception Si el depósito no es posible.
     */
    void depositar(Cuenta cuenta, double monto) throws Exception;

    /**
     * Consulta el saldo.
     *
     * @param cuenta El Contexto (la cuenta a consultar).
     * @return El saldo actual.
     */
    double consultarSaldo(Cuenta cuenta);
    
    /**
     * Intenta cerrar la cuenta.
     *
     * @param cuenta El Contexto (la cuenta a modificar).
     * @throws Exception Si la cuenta no se puede cerrar.
     */
    void cerrarCuenta(Cuenta cuenta) throws Exception;
}