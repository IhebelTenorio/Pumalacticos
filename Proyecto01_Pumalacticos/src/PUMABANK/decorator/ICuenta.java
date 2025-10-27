package PUMABANK.decorator;

import PUMABANK.observer.Observer;
import PUMABANK.strategy.IEstrategiaInteres;

/**
 * Interfaz Componente (para el patrón Decorator).
 * Define la interfaz común para los objetos que pueden ser decorados
 * y los decoradores mismos.
 *
 * @author PumaLacticos
 */
public interface ICuenta extends Observer{

    // Operaciones principales del cliente

    void retirar(double monto);
    void depositar(double monto);
    double getSaldo();
    void cerrarCuenta();
    void aplicarInteres();
    
    // Métodos de configuración y consulta
    
    void setEstrategiaInteres(IEstrategiaInteres nuevaEstrategia);
    String getNumeroDeCuenta();
    String getNombreCliente();
    String getDescripcion();
    default void update(){} //por default no hace nada, para no afectar otras clases
}