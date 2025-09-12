package pizzabot;

import java.util.Scanner;

import pizzabot.robot.Robot;

public class Pizzabot {
    private static Robot robot = new Robot();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        // Imprimir menú
        int opt;
        while(true){
            System.out.println("¿Desea despertar al robot?");
            System.out.println("1. Si");
            System.out.println("2. No");
            System.out.println("3. Salir");
            //Manejamos el caso en que no se coloque un número
            try{
                opt = sc.nextInt();
            } catch(Exception e){
                opt = 0; // Solo vamos a hacer como que no es válido
                System.out.println("Esa no es una opción válida, elija una del menú por favor");
                break;
            }
            switch (opt) {
                case 1:
                    robot.despierta();
                    break;
                case 2:
                    // Aquí puedes agregar la lógica para no despertar al robot
                    System.out.println("El robot permanecerá dormido.");
                case 3:
                    System.out.println("Hasta luego!");
                    return;
                default:
                    System.out.println("Invalido, elija una opción correcta por favor");
                    break;
            }
        }
    }
}
