package PUMABANK.decorator;

/**
 * Decorador Concreto: Seguro Antifraude.
 * Añade una capa de lógica de seguridad antes de permitir un retiro.
 *
 * @author PumaLacticos
 */
public class SeguroAntifraudeDecorator extends CuentaDecorator {

    public SeguroAntifraudeDecorator(ICuenta cuentaEnvuelva) {
        // Llama al constructor del padre (CuentaDecorator)
        super(cuentaEnvuelva);
    }

    /**
     * Sobrescribimos el método retirar para añadir nuestra lógica.
     */
    @Override
    public void retirar(double monto) {
        // AÑADIMOS NUEVO COMPORTAMIENTO (ANTES)
        if (analizarFraude(monto)) {
            System.out.println("Antifraude: Retiro de " + monto + " APROBADO.");
            // DELEGAMOS AL OBJETO ENVUELTO (usando super)
            super.retirar(monto);
        } else {
            System.err.println("¡FRAUDE! Retiro de " + monto + " BLOQUEADO por el seguro, contactate con el servidor.");
            // Bloqueamos la operación.
        }
    }

    /**
     * Lógica de negocio propia de este decorador.
     */
    private boolean analizarFraude(double monto) {
        // Lógica de simulación: cualquier retiro > $100,000 es sospechoso
        if (monto > 100000.0) {
            return false; // Es fraude
        }
        return true; // Es seguro
    }

    /**
     * También sobrescribimos la descripción para que el cliente
     * vea qué servicios tiene contratados.
     */
    @Override
    public String getDescripcion() {
        // Obtenemos la descripción base (del objeto envuelto)
        // Añadimos nuestra propia descripción
        return super.getDescripcion() + " + Seguro Antifraude";
    }
}