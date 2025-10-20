package PUMABANK.strategy;

import PUMABANK.Cuenta;

/**
 * Estrategia Concreta: Interés Anual.
 * Otorga 5% anual en el mes 12 si el saldo "promedio" es >= $50,000.
 *
 * @author PUMALACTICOS
 */
public class EstrategiaInteresAnual implements IEstrategiaInteres {

    private static final double TASA_ANUAL = 0.05; // 5%
    private static final double SALDO_PROMEDIO_MINIMO = 50000.0;

    @Override
    public double calcularInteres(Cuenta cuenta) {
        // NOTA: El PDF pide "saldo promedio". Un sistema real
        // requeriría que la Cuenta guarde un historial de saldos.
        // Para simplicidad del patrón, usaremos el saldo actual como aproximación.
        double saldoPromedioAproximado = cuenta.getSaldo();
        
        int antiguedad = cuenta.getAntiguedadMeses();

        // Verifica si es el mes 12 (o 24, 36, etc.) Y si cumple el saldo
        if (antiguedad > 0 && (antiguedad % 12 == 0) && saldoPromedioAproximado >= SALDO_PROMEDIO_MINIMO) {
            double interes = cuenta.getSaldo() * TASA_ANUAL;
            System.out.println("Interés ANUAL calculado: " + interes);
            return interes;
        } else {
            if (antiguedad > 0 && (antiguedad % 12 == 0)) {
                System.out.println("Interés ANUAL: No aplica (Mes 12, pero Saldo " + saldoPromedioAproximado + " < " + SALDO_PROMEDIO_MINIMO + ")");
            } else {
                // No es mes de aniversario
            }
            return 0.0;
        }
    }
}