package PUMABANK.strategy;

import PUMABANK.Cuenta;

/**
 * Estrategia Concreta: Interés Mensual.
 * Otorga 1.5% mensual si el saldo es >= $1,000.
 *
 * @author PUMALACTICOS
 */
public class EstrategiaInteresMensual implements IEstrategiaInteres {

    private static final double TASA_MENSUAL = 0.015; // 1.5%
    private static final double SALDO_MINIMO = 1000.0;

    @Override
    public double calcularInteres(Cuenta cuenta) {
        // Obtenemos el saldo usando el método PÚBLICO de Cuenta
        double saldoActual = cuenta.getSaldo(); 

        if (saldoActual >= SALDO_MINIMO) {
            double interes = saldoActual * TASA_MENSUAL;
            System.out.println("Interés MENSUAL calculado: " + interes);
            return interes;
        } else {
            System.out.println("Interés MENSUAL: No aplica (Saldo " + saldoActual + " < " + SALDO_MINIMO + ")");
            return 0.0;
        }
    }
}
