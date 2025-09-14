package pizzabot.robot;

import pizzabot.helados.Helado;
import pizzabot.pizza.Pizza;

public class Preparar implements RobotState {

    public void llamar(Robot robot) {
        System.out.println("ERROR: El robot está ocupado preparando una orden. Por favor espere");
    }
    public void confirmarOrden(Robot robot) {
        System.out.println("ERROR: Ya hay una orden");
    }
    public void cancelarOrden(Robot robot) {
        System.out.println("ERROR: La orden ya está preparandose y no se puede cancelar");
    }

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
    
    public void entregar(Robot robot) {
        System.out.println("ERROR: La orden aún se está preparando, por favor espere.");
    }
}