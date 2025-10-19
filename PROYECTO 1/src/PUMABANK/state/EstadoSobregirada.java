package PUMABANK.state;

import PUMABANK.Cuenta;

/**
 * Estado Concreto: Sobregirada.
 * Aplica cargos. Solo permite depósitos.
 *
 * @author PUMALACTICOS
 */
public class EstadoSobregirada implements IEstadoCuenta {

    private static final double CARGO_POR_SOBREGIRO = 50.0; 

    // Asegurar que el cargo se aplique solo una vez por transición
    private boolean cargoAplicado = false; 

    @Override
    public void retirar(Cuenta cuenta, double monto) throws Exception {
        // "se le aplica un cargo antes de permitirle operar de nuevo"
        // Interpretamos que no puede retirar, solo depositar para salir.
        aplicarCargo(cuenta); // Aplica el cargo si es la primera operación
        throw new Exception("Retiro RECHAZADO. La cuenta está SOBREGIRADA. Saldo actual: " + cuenta.getSaldoInterno());
    }

    @Override
    public void depositar(Cuenta cuenta, double monto) throws Exception {
        aplicarCargo(cuenta); // Aplica el cargo si no se ha hecho
        
        System.out.println("Depósito en cuenta sobregirada...");
        cuenta.setSaldoInterno(cuenta.getSaldoInterno() + monto);
        System.out.println("Depósito de " + monto + " aplicado. Saldo actual: " + cuenta.getSaldoInterno());

        // ¡Transición de estado de regreso!
        if (cuenta.getSaldoInterno() >= 0) {
            System.out.println("¡Saldo positivo! Transicionando de regreso a ACTIVA.");
            cuenta.setEstado(new EstadoActiva());
        }
    }

    @Override
    public double consultarSaldo(Cuenta cuenta) {
        return cuenta.getSaldoInterno();
    }
    
    @Override
    public void cerrarCuenta(Cuenta cuenta) throws Exception {
        throw new Exception("No se puede cerrar una cuenta SOBREGIRADA. Saldo actual: " + cuenta.getSaldoInterno());
    }
    
    /**
     * Lógica interna para aplicar el cargo de sobregiro
     */
    private void aplicarCargo(Cuenta cuenta) {
        if (!cargoAplicado) {
            System.err.println("Aplicando cargo por sobregiro de: " + CARGO_POR_SOBREGIRO);
            cuenta.setSaldoInterno(cuenta.getSaldoInterno() - CARGO_POR_SOBREGIRO);
            System.err.println("Nuevo saldo tras cargo: " + cuenta.getSaldoInterno());
            this.cargoAplicado = true;
        }
    }
}