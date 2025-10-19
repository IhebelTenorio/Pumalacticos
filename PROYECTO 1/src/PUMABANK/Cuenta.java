package PUMABANK;

import PUMABANK.state.EstadoActiva;
import PUMABANK.state.EstadoCerrada;
import PUMABANK.state.EstadoCongelada;
import PUMABANK.state.EstadoSobregirada;
import PUMABANK.state.IEstadoCuenta;
import PUMABANK.strategy.IEstrategiaInteres;
import PUMABANK.strategy.EstrategiaInteresMensual;

/**
 * Clase Cuenta (Contexto para el patrón State y Strategy por el momento).
 * Delega su comportamiento de operaciones al objeto de estado actual.
 *
 * @author PUMALACTICOS
 */
public class Cuenta {

    // Atributos principales
    private String numeroDeCuenta;
    private String nombreCliente;
    private double saldo;
    private int antiguedadMeses;

    /**
     * Variable clave del patrón State y Strategy.
     * Mantiene una referencia al objeto de estado actual.
     */
    private IEstadoCuenta estadoActual;
    private IEstrategiaInteres estrategiaInteres;

    /**
     * Constructor de la Cuenta.
     *
     * @param numeroDeCuenta Identificador único.
     * @param nombreCliente Nombre del titular.
     * @param saldoInicial Saldo de apertura.
     * @param estrategiaInicial La estrategia de interés para esta cuenta.
     */
    public Cuenta(String numeroDeCuenta, String nombreCliente, double saldoInicial, IEstrategiaInteres estrategiaInicial) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.nombreCliente = nombreCliente;
        this.saldo = saldoInicial;
        
        this.antiguedadMeses = 0;
        
        // Inicializamos el estado.
        // Las clases de estado ahora están en otro paquete.
        if (this.saldo >= 0) {
            this.estadoActual = new EstadoActiva();
        } else {
            this.estadoActual = new EstadoSobregirada();
        }
        System.out.println("Cuenta " + numeroDeCuenta + " creada. Estado inicial: " + this.estadoActual.getClass().getSimpleName());


        this.estrategiaInteres = estrategiaInicial;

        // Asignar una estrategia por defecto si nos pasan null
        if (this.estrategiaInteres == null) {
            System.out.println("Advertencia: No se proveyó estrategia, usando 'Mensual' por defecto.");
            this.estrategiaInteres = new EstrategiaInteresMensual();
        }
        
        System.out.println("Cuenta " + numeroDeCuenta + " creada. Estado: " + this.estadoActual.getClass().getSimpleName() + 
                           ", Estrategia: " + this.estrategiaInteres.getClass().getSimpleName());
    }

    

    // MÉTODOS DE STATE
    // El cliente llama a estos métodos. La cuenta simplemente
    // reenvía la llamada al objeto de estado actual.

    public void retirar(double monto) {
        try {
            // Pasamos 'this' (la instancia de Cuenta) como contexto
            this.estadoActual.retirar(this, monto);
        } catch (Exception e) {
            System.err.println("Error en retiro (" + this.numeroDeCuenta + "): " + e.getMessage());
        }
    }

    public void depositar(double monto) {
         try {
            this.estadoActual.depositar(this, monto);
        } catch (Exception e) {
            System.err.println("Error en depósito (" + this.numeroDeCuenta + "): " + e.getMessage());
        }
    }
    
    public double getSaldo() {
        // La consulta de saldo también es controlada por el estado
        return this.estadoActual.consultarSaldo(this);
    }
    
    public void cerrarCuenta() {
        try {
            this.estadoActual.cerrarCuenta(this);
        } catch (Exception e) {
            System.err.println("Error al cerrar cuenta (" + this.numeroDeCuenta + "): " + e.getMessage());
        }
    }

    // MÉTODOS PARA STRATEGY

    /**
     * Delega el cálculo del interés a la estrategia actual
     * y aplica el monto depositándolo en la cuenta.
     */
    public void aplicarInteres() {
        System.out.println("Procesando intereses para cuenta: " + numeroDeCuenta);
        // 1. Delega el CÁLCULO a la estrategia
        double interesCalculado = this.estrategiaInteres.calcularInteres(this);

        if (interesCalculado > 0) {
            System.out.println("Aplicando interés de: " + interesCalculado);
            // 2. Aplica el interés usando nuestro método depositar()
            // Al usar depositar(), el patrón STATE se encarga
            // de manejar el depósito (ej. sacar de Sobregirada a Activa).
            this.depositar(interesCalculado);
        } else {
            System.out.println("No hay intereses para aplicar este periodo.");
        }
    }

    /**
     * Permite cambiar la estrategia de interés en tiempo de ejecución.
     * (Ej. El cliente mejora su plan de 'Mensual' a 'Premium')
     *
     * @param nuevaEstrategia El nuevo objeto de estrategia.
     */
    public void setEstrategiaInteres(IEstrategiaInteres nuevaEstrategia) {
        this.estrategiaInteres = nuevaEstrategia;
        System.out.println("INFO (" + this.numeroDeCuenta + "): Estrategia de interés actualizada a -> " + 
                           nuevaEstrategia.getClass().getSimpleName());
    }
    
    /**
     * Simula el paso del tiempo.
     */
    public void simularPasoDeMes() {
        this.antiguedadMeses++;
    }

    // MÉTODOS DE CONTROL (PÚBLICOS)
    // Estos son los métodos que los objetos de estado (en otro paquete)
    // necesitan llamar. DEBEN SER PÚBLICOS.

    /**
     * Método MUTATOR (setter) crucial.
     * Permite a los objetos de estado cambiar el estado actual de la cuenta.
     *
     * @param nuevoEstado El nuevo objeto de estado.
     */
    public void setEstado(IEstadoCuenta nuevoEstado) {
        this.estadoActual = nuevoEstado;
        System.out.println("INFO (" + this.numeroDeCuenta + "): Transición de estado a -> " + nuevoEstado.getClass().getSimpleName());
    }

    /**
     * Permite a los estados modificar el saldo.
     * @param nuevoSaldo el nuevo saldo.
     */
    public void setSaldoInterno(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }
    
    /**
     * Permite a los estados leer el saldo real.
     * @return el saldo.
     */
    public double getSaldoInterno() {
        return this.saldo;
    }

    // Getters públicos para información (útiles para otros patrones)
    
    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public int getAntiguedadMeses() {
        return antiguedadMeses;
    }
}
