package PUMABANK.strategy;

import PUMABANK.Cuenta;

/**
 * Interfaz para el patrón de diseño Strategy.
 * Define el contrato para cualquier algoritmo de cálculo de interés.
 *
 * @author PUMALACTICOS
 */
public interface IEstrategiaInteres {

    /**
     * Calcula el interés para la cuenta dada.
     * La lógica específica será implementada por las clases concretas.
     *
     * @param cuenta El Contexto (la cuenta) sobre la cual calcular el interés.
     * @return El monto del interés calculado (puede ser 0 si no aplica).
     */
    double calcularInteres(Cuenta cuenta);
}