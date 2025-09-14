package pizzabot; 

    import java.util.Scanner;
    import pizzabot.robot.Robot;

// Clase principal que contiene el método main para ejecutar la simulación de optimus prime.

public class Pizzabot {

    public static void main(String[] args) {
        System.out.println("Bienvenido a Pitzapitza");

        Robot Cesarin = new Robot();

        Cesarin.llamar();

        System.out.println("Presiona ENTER para solicitar la entrega de tu orden.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        Cesarin.entregar();

        System.out.println("\n Regresa pronto (en robot)");

        
        scanner.close();
    }
}
