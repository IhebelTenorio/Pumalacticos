
package PUMABANK.state;

// Importamos la clase Cuenta del paquete raíz 'PUMABANK'
import PUMABANK.Cuenta;

/**
 * Estado Concreto: Activa.
 * Permite operaciones normales.
 *
 * @author PUMALACTICOS
 */
public class EstadoActiva implements IEstadoCuenta {

    @Override
    public void retirar(Cuenta cuenta, double monto) throws Exception {
        // Llama al método PÚBLICO de Cuenta
        double saldoActual = cuenta.getSaldoInterno(); 
        
        if (monto <= saldoActual) {
            // Retiro normal
            // Llama al método PÚBLICO de Cuenta
            cuenta.setSaldoInterno(saldoActual - monto);
            System.out.println("Retiro exitoso de: " + monto + ". Saldo restante: " + cuenta.getSaldoInterno());
        } else {
            // Transición de estado según PDF
            System.err.println("Fondos insuficientes (" + saldoActual + "). Transicionando a SOBREGIRADA.");
            // Llama al método PÚBLICO de Cuenta y pasa un NUEVO objeto de estado
            cuenta.setEstado(new EstadoSobregirada());
            throw new Exception("Fondos insuficientes. La cuenta ahora está SOBREGIRADA.");
        }
    }

    @Override
    public void depositar(Cuenta cuenta, double monto) throws Exception {
        cuenta.setSaldoInterno(cuenta.getSaldoInterno() + monto);
        System.out.println("Depósito exitoso de: " + monto + ". Saldo actual: " + cuenta.getSaldoInterno());
        // Si estaba Activa, sigue Activa. No hay transición.
    }

    @Override
    public double consultarSaldo(Cuenta cuenta) {
        return cuenta.getSaldoInterno();
    }
    
    @Override
    public void cerrarCuenta(Cuenta cuenta) throws Exception {
        if (cuenta.getSaldoInterno() != 0) {
            throw new Exception("No se puede cerrar. El saldo debe ser 0. Saldo actual: " + cuenta.getSaldoInterno());
        }
        System.out.println("Cerrando cuenta...");
        cuenta.setEstado(new EstadoCerrada());
    }
}