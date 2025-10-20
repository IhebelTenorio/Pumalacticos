package PUMABANK.state;

import PUMABANK.Cuenta;

/**
 * Estado Concreto: Cerrada.
 * No permite ninguna operación monetaria.
 *
 * @author PUMALACTICOS
 */
public class EstadoCerrada implements IEstadoCuenta {

    @Override
    public void retirar(Cuenta cuenta, double monto) throws Exception {
        throw new Exception("Operación inválida. La cuenta está CERRADA.");
    }

    @Override
    public void depositar(Cuenta cuenta, double monto) throws Exception {
        throw new Exception("Operación inválida. La cuenta está CERRADA.");
    }

    @Override
    public double consultarSaldo(Cuenta cuenta) {
        System.out.println("La cuenta está CERRADA. Saldo final registrado: " + cuenta.getSaldoInterno());
        return cuenta.getSaldoInterno();
    }
    
    @Override
    public void cerrarCuenta(Cuenta cuenta) throws Exception {
        System.out.println("La cuenta ya se encuentra CERRADA.");
    }
}