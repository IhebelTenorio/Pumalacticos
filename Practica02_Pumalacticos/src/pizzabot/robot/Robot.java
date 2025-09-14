package pizzabot.robot;

import pizzabot.helados.Helado;
import pizzabot.pizza.Pizza;

public class Robot {

    private RobotState estadoDormido;
    private RobotState estadoAtendiendo;
    private RobotState estadoPreparando;
    private RobotState estadoEntregando;

    private RobotState estadoActual;

    private Pizza pizzaEnOrden;
    private Helado heladoEnOrden;

    public Robot() {
        this.estadoDormido = new Dormir();
        this.estadoAtendiendo = new Atender();
        this.estadoPreparando = new Preparar();
        this.estadoEntregando = new Entregando();
        
        // Inicia dormido
        this.estadoActual = estadoDormido;
        System.out.println("CesarinBot inicializado. Estado: Dormido 'zzzzzz...' ");
    }

    public void llamar() {
        estadoActual.llamar(this);
        if (estadoActual instanceof Atender) {
            ((Atender) estadoActual).tomarOrden(this);
        }
    }

    public void confirmarOrden() {
        estadoActual.confirmarOrden(this);
    }

    public void cancelarOrden() {
        estadoActual.cancelarOrden(this);
        limpiarOrden(); // Limpiamos el carrito si se cancela
    }

    public void preparar() {
        estadoActual.preparar(this);
    }

    public void entregar() {
        estadoActual.entregar(this);
    }

    // Limpia la orden actual
    
    public void limpiarOrden() {
        this.pizzaEnOrden = null;
        this.heladoEnOrden = null;
        System.out.println("La orden se reinició.");
    }

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