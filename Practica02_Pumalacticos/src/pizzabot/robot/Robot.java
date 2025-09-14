package pizzabot.robot;

import pizzabot.helados.Helado;
import pizzabot.pizza.Pizza;

/**
 * La clase que representa el robot encargado de atender, preparar y entregar pedidos de pizzas y helados
 */
public class Robot {

    private RobotState estadoDormido;
    private RobotState estadoAtendiendo;
    private RobotState estadoPreparando;
    private RobotState estadoEntregando;

    private RobotState estadoActual;

    private Pizza pizzaEnOrden;
    private Helado heladoEnOrden;

    /**
     * Constructor que inicializa los estados del robot y lo coloca en el esatdo de dormir
     */
    public Robot() {
        this.estadoDormido = new Dormir();
        this.estadoAtendiendo = new Atender();
        this.estadoPreparando = new Preparar();
        this.estadoEntregando = new Entregando();
        
        // Inicia dormido
        this.estadoActual = estadoDormido;
        System.out.println("CesarinBot inicializado. Estado: Dormido 'zzzzzz...' ");
    }

    /**
     * Llama al robot para que atienda al cliente 
     */
    public void llamar() {
        estadoActual.llamar(this);
        if (estadoActual instanceof Atender) {
            ((Atender) estadoActual).tomarOrden(this);
        }
    }

    /**
     * Confirma la prden actual
     */
    public void confirmarOrden() {
        estadoActual.confirmarOrden(this);
    }

    /**
     * Cancela la orden actual
     */
    public void cancelarOrden() {
        estadoActual.cancelarOrden(this);
        limpiarOrden(); // Limpiamos el carrito si se cancela
    }

    /**
     * Inicia la preparación de la orden
     */
    public void preparar() {
        estadoActual.preparar(this);
    }

    /**
     * Entrega la orden al cliente
     */
    public void entregar() {
        estadoActual.entregar(this);
    }
    
    /**
     * Limpia la orden actual, eliminando la pizza y el helado seleccionado
     */
    public void limpiarOrden() {
        this.pizzaEnOrden = null;
        this.heladoEnOrden = null;
        System.out.println("La orden se reinició.");
    }

    /**
     * Cambia el estado actual del robot
     * @param nuevoEstado el nuevo estado que tendra el robot
     */
    public void setEstado(RobotState nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public RobotState getEstadoActual() {
    return estadoActual; }

    public RobotState getEstadoDormido() { 
        return estadoDormido; }

    public RobotState getEstadoAtendiendo() { 
        return estadoAtendiendo; }

    public RobotState getEstadoPreparando() { 
        return estadoPreparando; }

    public RobotState getEstadoEntregando() { 
        return estadoEntregando; }

    public Pizza getPizzaEnOrden() { 
        return pizzaEnOrden; }

    public void setPizzaEnOrden(Pizza pizza) { 
        this.pizzaEnOrden = pizza; }

    public Helado getHeladoEnOrden() { 
        return heladoEnOrden; }
        
    public void setHeladoEnOrden(Helado helado) { 
        this.heladoEnOrden = helado; }
}