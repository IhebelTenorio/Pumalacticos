
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
            cuenta.setSaldoInterno(saldoActual - monto);
            String msg = ("Retiro exitoso de: " + monto + ". Saldo restante: " + cuenta.getSaldoInterno());
            System.out.println(msg);
            cuenta.notificar(msg);
        } else {
            cuenta.setSaldoInterno(saldoActual - monto); // Aplicamos el retiro negativo
            String msg = "RETIRO FALLIDO (SOBREGIRO): Se intentó retirar $" + monto + ". Saldo actual: " + cuenta.getSaldoInterno();
            System.err.println(msg);
            // setEstado notificará el cambio a Sobregirada
            cuenta.setEstado(new EstadoSobregirada()); 
            cuenta.notificar(msg);
            throw new Exception("Fondos insuficientes. La cuenta ahora está SOBREGIRADA. Saldo: " + cuenta.getSaldoInterno());
        }
    }

    @Override
    public void depositar(Cuenta cuenta, double monto) throws Exception {
        cuenta.setSaldoInterno(cuenta.getSaldoInterno() + monto);
        String msg = ("Depósito exitoso de: " + monto + ". Saldo actual: " + cuenta.getSaldoInterno());
        System.out.println(msg);
        cuenta.notificar(msg);
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