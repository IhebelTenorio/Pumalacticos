package PUMABANK.decorato;

/**
 * Decorador Concreto: Programa de Recompensas.
 * Añade puntos de recompensa después de un depósito.
 *
 * @author PumaLacticos
 */
public class RecompensasDecorator extends CuentaDecorator {
    
    private int puntosRecompensa = 0;

    public RecompensasDecorator(ICuenta cuentaEnvuelva) {
        super(cuentaEnvuelva);
    }

    /**
     * Sobrescribimos el método depositar para añadir nuestra lógica.
     */
    @Override
    public void depositar(double monto) {
        //DELEGAMOS AL OBJETO ENVUELTO PRIMERO
        super.depositar(monto);
        
        // AÑADIMOS NUEVO COMPORTAMIENTO (DESPUÉS)
        int puntosGanados = (int) (monto / 10); // 1 punto por cada $10
        if (puntosGanados > 0) {
            this.puntosRecompensa += puntosGanados;
            System.out.println("Recompensas: Ganaste " + puntosGanados + " puntos por tu compra. Total: " + this.puntosRecompensa);
        }
    }
    
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Programa de Recompensas (" + this.puntosRecompensa + " puntos)";
    }
    
    // Método propio de este decorador
    public int getPuntosRecompensa() {
        return this.puntosRecompensa;
    }
}