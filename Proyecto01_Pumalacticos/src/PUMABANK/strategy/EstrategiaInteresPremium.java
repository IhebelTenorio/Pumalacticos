package PUMABANK.strategy;

import PUMABANK.Cuenta;

/**
 * Estrategia Concreta: Interés Premium.
 * Otorga un 3% mensual sin saldo mínimo.
 *
 * @author PUMALACTICOS
 */
public class EstrategiaInteresPremium implements IEstrategiaInteres {

    private static final double TASA_PREMIUM = 0.03; // 3%

    @Override
    public double calcularInteres(Cuenta cuenta) {
        double saldoActual = cuenta.getSaldo();
        if (saldoActual > 0) {
            double interes = saldoActual * TASA_PREMIUM;
            System.out.println("Interés PREMIUM calculado: " + interes);
            return interes;
        }
        return 0.0;
    }
}