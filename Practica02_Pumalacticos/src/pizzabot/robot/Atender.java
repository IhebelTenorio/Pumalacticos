package pizzabot.robot;

import java.util.Scanner;

public class Atender implements RobotState{
    private Robot context;
    private Scanner sc = new Scanner(System.in);
    public Atender(Robot context){
        this.context = context;
    }

    public void action(){
        // Imprimir menú
        int optMenu;
        int optPizza;
        int optHelado;
        int optTopping;
        while(true){
            System.out.println("Elija que desea agregar al carrito o 4 para salir.");
            System.out.println("1. Agregar una pizza");
            System.out.println("2. Agregar un helado");
            System.out.println("3. Agregar una pizza y un helado");
            //Manejamos el caso en que no se coloque un número
            try{
                optMenu = sc.nextInt();
            } catch(Exception e){
                optMenu = 0; // La verdad no vamos a lidiar con el error, solo vamos a hacer como que no es válido
                System.out.println("Esa no es una opción válida, elija una del menú por favor");
                break;
            }
            switch (optMenu) {
                case 1,3: // Agregar pizza
                    while(true){
                        System.out.println("Elija el sabo de su pizza.");
                        System.out.println("1. Pepperoni");
                        System.out.println("2. Tocino");
                        System.out.println("3. Mexicana");
                        System.out.println("4. Carnes");
                        System.out.println("5. Tres Quesos [Vegetariana!]");
                        System.out.println("6. Champiñón [Vegetariana!]\n");
                        System.out.println("7. Cancelar <-");
                        //Manejamos el caso en que no se coloque un número
                        try{
                            optPizza = sc.nextInt();
                        } catch(Exception e){
                            optPizza = 0; // La verdad no vamos a lidiar con el error, solo vamos a hacer como que no es válido
                            System.out.println("Esa no es una opción válida, elija una del menú por favor");
                        }
                        switch (optPizza) {
                            case 1:
                                
                                break;
                            case 7:
                                System.out.println("El robot vuelve a su sueño");
                                context.state = new Dormir();
                                return;
                            default:
                                break;
                        }

                    }
                case 2: // preparar helado
                    while(true){
                        System.out.println("Elija el sabo de su pizza.");
                        System.out.println("1. Pepperoni");
                        System.out.println("2. Tocino");
                        System.out.println("3. Mexicana");
                        System.out.println("4. Carnes");
                        System.out.println("5. Tres Quesos [Vegetariana!]");
                        System.out.println("6. Champiñón [Vegetariana!]\n");
                        System.out.println("7. Cancelar <-");
                        //Manejamos el caso en que no se coloque un número
                        try{
                            optPizza = sc.nextInt();
                        } catch(Exception e){
                            optPizza = 0; // La verdad no vamos a lidiar con el error, solo vamos a hacer como que no es válido
                            System.out.println("Esa no es una opción válida, elija una del menú por favor");
                        }
                        switch (optPizza) {
                            case 1:
                                
                                break;
                            case 7:
                                System.out.println("El robot vuelve a su sueño");
                                context.state = new Dormir();
                                return;
                            default:
                                break;
                        }

                    }
                    //break;
                case 4:
                    System.out.println("El robot vuelve a su sueño");
                    context.state = new Dormir();
                    return;
                default:
                System.out.println("Esa no es una opción válida, elija una del menú por favor");
                break;
            }
        }
        
    }
}
