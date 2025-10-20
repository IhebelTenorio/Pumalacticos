package PUMABANK.state;

import PUMABANK.Cuenta;

/**
 * Estado Concreto: Congelada.
 * "quedando todas las operaciones bloqueadas"
 *
 * @author PUMALACTICOS
 */
public class EstadoCongelada implements IEstadoCuenta {

    @Override
    public void retirar(Cuenta cuenta, double monto) throws Exception {
        throw new Exception("OPERACIÓN BLOQUEADA: La cuenta está CONGELADA.");
    }

    @Override
    public void depositar(Cuenta cuenta, double monto) throws Exception {
        throw new Exception("OPERACIÓN BLOQUEADA: La cuenta está CONGELADA.");
    }

    @Override
    public double consultarSaldo(Cuenta cuenta) {
        /* Asumimos que "todas las operaciones" incluye consultar saldo */
        System.err.println("CONSULTA BLOQUEADA: La cuenta está CONGELADA.");
        return 0.0; // Oculta el saldo
    }
    
    @Override
    public void cerrarCuenta(Cuenta cuenta) throws Exception {
        throw new Exception("OPERACIÓN BLOQUEADA: No se puede cerrar una cuenta CONGELADA.");
    }
}