package pizzabot.robot;

import pizzabot.helados.Helado;
import pizzabot.pizza.Pizza;

/**
 * La clase el cual en este estado el robot se pone en un estado donde prepara la orden recibida del cliente
 * de la pizza y el helado, implementando la interfaz RobotState 
 */
public class Preparar implements RobotState {

    /**
     * Muestra un error si intenta llamar al robot 
     * @param robot instancia del robot
     */
    @Override
    public void llamar(Robot robot) {
        System.out.println("ERROR: El robot está ocupado preparando una orden. Por favor espere");
    }

    /**
     * Muestra error si intenta confirmar una orden 
     * @param robot instancia del robot
     */
    @Override
    public void confirmarOrden(Robot robot) {
        System.out.println("ERROR: Ya hay una orden");
    }

    /**
     * Muestra un error si se intenta cancelar una orden mientras se prepara
     * @param robot instancia del robot
     */
    @Override
    public void cancelarOrden(Robot robot) {
        System.out.println("ERROR: La orden ya está preparandose y no se puede cancelar");
    }

    /**
     * Método principal que realiza la preparación de la orden
     * @param robot instancia del robot que tiene la orden
     */
    @Override
    public void preparar(Robot robot) {
        System.out.println("\n Preparando la orden...");

        try {
            // Revisa si hay una pizza en la orden
            Pizza pizza = robot.getPizzaEnOrden();
            if (pizza != null) {
                // Template: cada tipo de pizza tiene su propio método preparar()
                pizza.preparar();
            }

            // Revisa si hay un helado
            Helado helado = robot.getHeladoEnOrden();
            if (helado != null) {
                System.out.println("\n Iniciando preparación de Helado ");
                System.out.println("1. Tomando vaso");
                Thread.sleep(1000);
                System.out.println("2. Servir helado");
                Thread.sleep(1500);
                System.out.println("3. Añadiendo topping (si no hay no se preocupe)");
                Thread.sleep(2000);
                System.out.println("¡Helado listo!");
            }
            
            System.out.println("\n PREPARACIÓN COMPLETA: La orden está lista para ser entregada.");

            // Entregando
            robot.setEstado(robot.getEstadoEntregando());
            System.out.println("El robot ahora está en modo 'Entregando'.");

        } catch (InterruptedException e) {
            System.out.println("Ocurrió un error durante la preparación.");
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Muestra un error si se intenta entregar la orden mientars se prepara 
     * @param robot instancia del robot
     */
    @Override
    public void entregar(Robot robot) {
        System.out.println("ERROR: La orden aún se está preparando, por favor espere.");
    }
}