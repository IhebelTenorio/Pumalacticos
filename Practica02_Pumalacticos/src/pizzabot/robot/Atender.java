package pizzabot.robot;

import java.util.Scanner;

public class Atender implements RobotState{

    private Scanner sc = new Scanner(System.in);
    public Atender(){}

    public void action(){
        // Imprimir menú
        int opt;
        while(true){
            System.out.println("Elija que desea agregar al carrito o 4 para salir.");
            System.out.println("1. Agregar una pizza");
            System.out.println("2. Agregar un helado");
            System.out.println("3. Agregar una pizza y un helado");
            //Manejamos el caso en que no se coloque un número
            try{
                opt = sc.nextInt();
            } catch(Exception e){
                opt = 0; // La verdad no vamos a lidiar con el error, solo vamos a hacer como que no es válido
                System.out.println("Esa no es una opción válida, elija una del menú por favor");
                break;
            }
            switch (opt) {
                case 1:
                
                    
                    break;
                default:
                    break;
            }
        }
        
    }
}
