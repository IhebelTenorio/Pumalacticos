package pizzabot.robot;

import java.util.Scanner;
import pizzabot.helados.*;
import pizzabot.pizza.*;
public class Atender implements RobotState {

    private Scanner scanner = new Scanner(System.in);

    // Método principal que gestiona el menú de atención al cliente.
     
    public void tomarOrden(Robot robot) {
        System.out.println("\n¡Hola! ¿Qué te gustaría ordenar hoy?");
        
        while (robot.getEstadoActual() instanceof Atender) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    menuOrdenarPizza(robot);
                    break;
                case 2:
                    menuOrdenarHelado(robot);
                    break;
                case 3:
                    verOrdenActual(robot);
                    break;
                case 4:
                    if (robot.getPizzaEnOrden() == null && robot.getHeladoEnOrden() == null) {
                        System.out.println("Tu orden está vacía. Por favor, añade algo antes de confirmar.");
                    } else {
                        robot.confirmarOrden();
                    }
                    break;
                case 5:
                    robot.cancelarOrden();
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n MENÚ ");
        System.out.println("1. Ordenar Pizza (Solo puedes elegir una)");
        System.out.println("2. Ordenar Helado (Solo puedes elegir uno)");
        System.out.println("3. Ver mi orden actual");
        System.out.println("4. Confirmar mi orden");
        System.out.println("5. Cancelar mi orden");
        System.out.print("Elige una opción: ");
    }

    private void menuOrdenarPizza(Robot robot) {
        System.out.println("\n PIZZAS CESARIN ");
        System.out.println("1. Pepperoni $120");
        System.out.println("2. Hawaiana $130");
        System.out.println("3. Cuatro Quesos $145");
        System.out.println("4. Pollo $150");
        System.out.println("5. Vegetariana $115");
        System.out.println("6. Bistec $160");
        System.out.print("Elige tu pizza: ");
        int eleccionPizza = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n Elige tu tipo de masa ");
        System.out.println("1. Napolitana (Delgada)");
        System.out.println("2. Romana (Gruesa)");
        System.out.println("3. Americana (Orilla de queso)");
        System.out.print("Elige tu masa: ");
        int eleccionMasa = scanner.nextInt();
        scanner.nextLine();
        
        String tipoMasa = "Napolitana";
        if (eleccionMasa == 2) tipoMasa = "Romana";
        if (eleccionMasa == 3) tipoMasa = "Americana";

        Pizza pizzaSeleccionada = null;
        switch (eleccionPizza) {
            case 1: pizzaSeleccionada = new PizzaPeperonni(tipoMasa); 
            break;
            case 2: pizzaSeleccionada = new PizzaHawaiana(tipoMasa); 
            break;
            case 3: pizzaSeleccionada = new PizzaCuatroQuesos(tipoMasa); 
            break;
            case 4: pizzaSeleccionada = new PizzaPollo(tipoMasa); 
            break;
            case 5: pizzaSeleccionada = new PizzaVegetariana(tipoMasa); 
            break;
            case 6: pizzaSeleccionada = new PizzaBistec(tipoMasa); 
            break;
            default: System.out.println("Selección de pizza no válida."); 
            return;
        }

        robot.setPizzaEnOrden(pizzaSeleccionada);
        System.out.println(pizzaSeleccionada.getNombre() + " con " + tipoMasa + " añadida a tu orden");
    }

    private void menuOrdenarHelado(Robot robot) {
        System.out.println("\n MENÚ DE HELADOS ");
        System.out.println("1. Fresa $25");
        System.out.println("2. Vainilla $25");
        System.out.println("3. Chocolate $25");
        System.out.print("Elige tu sabor: ");
        int eleccionSabor = scanner.nextInt();
        scanner.nextLine();

        Helado helado = null;
        switch (eleccionSabor) {
            case 1: helado = new HeladoBase(25, "Fresa"); 
            break;
            case 2: helado = new HeladoBase(25, "Vainilla"); 
            break;
            case 3: helado = new HeladoBase(25, "Chocolate"); 
            break;
            default: System.out.println("Sabor no válido."); 
            return;
        }

        //ingredientes extra (Decorators)
        int countChispas = 0;
        int countGusanitos = 0; 
        int countPanditas = 0;
        int countManguitos = 0;
        int countAros = 0;
        int countFresa = 0;
        int countKiwis = 0;
        int countMalvaviscos = 0;

        while (true) {
            System.out.println("\n AÑADIR INGREDIENTES EXTRA (c/u $5) (máximo 3 de cada uno) ");
            System.out.println("Tu helado es: " + helado.getDescripcion() + " ($" + helado.getPrecio() + ")");
            System.out.println("1. Chispas");
            System.out.println("2. Gusanitos");
            System.out.println("3. Panditas");
            System.out.println("4. Manguitos");
            System.out.println("5. Aros");
            System.out.println("6. Fresa");
            System.out.println("7. Kiwis");
            System.out.println("8. Malvaviscos");
            System.out.println("0. Sin extras");
            System.out.print("Añade un ingrediente (o pulse 0 para terminar): ");
            int eleccionIngrediente = scanner.nextInt();
            scanner.nextLine();

            if (eleccionIngrediente == 0) 
            break;

            //Para que haya maximo 3 ingredientes de cada tipo
            switch (eleccionIngrediente) {
            case 1:
                if (countChispas < 3) {
                    helado = new ConChispas(helado);
                    countChispas++;
                    System.out.println("Chispas añadidas.");
                } else {
                    System.out.println("Límite de Chispas alcanzado.");
                }
                break;
            case 2:
                if (countGusanitos < 3) {
                    helado = new ConGusanitos(helado);
                    countGusanitos++;
                    System.out.println("Gusanitos añadidos.");
                } else {
                    System.out.println("Límite de Gusanitos alcanzado.");
                }
                break;
            case 3:
                if (countPanditas < 3) {
                    helado = new ConPanditas(helado);
                    countPanditas++;
                    System.out.println("Panditas añadidos.");
                } else {
                    System.out.println("Límite de Panditas alcanzado.");
                }
                break;
            case 4:
                if (countManguitos < 3) {
                    helado = new ConManguitos(helado);
                    countManguitos++;
                    System.out.println("Manguitos añadidos.");
                } else {
                    System.out.println("Límite de Manguitos alcanzado.");
                }
                break;
            case 5: 
                if (countAros < 3) {
                    helado = new ConAros(helado);
                    countAros++;
                    System.out.println("Aros añadidos.");
                } else {
                    System.out.println("Límite de Aros alcanzado.");
                }
                break;
            case 6: 
                if (countFresa < 3) {
                    helado = new ConFresa(helado);
                    countFresa++;
                    System.out.println("Fresa añadida.");
                } else {
                    System.out.println("Límite de Fresa alcanzado.");
                }
                break;
            case 7: 
                if (countKiwis < 3) {
                    helado = new ConKiwis(helado);
                    countKiwis++;
                    System.out.println("Kiwis añadidos.");
                } else {
                    System.out.println("Límite de Kiwis alcanzado.");
                }
                break;
            case 8: 
                if (countMalvaviscos < 3) {
                    helado = new ConMalvaviscos(helado);
                    countMalvaviscos++;
                    System.out.println("Malvaviscos añadidos.");
                } else {
                    System.out.println("Límite de Malvaviscos alcanzado.");
                }
                break;
            default: System.out.println("Ingrediente no válido.");

            switch (eleccionIngrediente) {
                case 1: helado = new ConChispas(helado); 
                break;
                case 2: helado = new ConGusanitos(helado); 
                break;
                case 3: helado = new ConPanditas(helado); 
                break;
                case 4: helado = new ConManguitos(helado); 
                break;
                case 5: helado = new ConAros(helado); 
                break;
                case 6: helado = new ConFresa(helado); 
                break;
                case 7: helado = new ConKiwis(helado); 
                break;
                case 8: helado = new ConMalvaviscos(helado); 
                break;
                default: System.out.println("Ingrediente no válido.");
            }
        }
        
        robot.setHeladoEnOrden(helado);
        System.out.println("Helado añadido a tu orden");
    }
    }

    private void verOrdenActual(Robot robot) {
        System.out.println("\n TU ORDEN ACTUAL ");
        if (robot.getPizzaEnOrden() != null) {
            System.out.println("Pizza: " + robot.getPizzaEnOrden().getNombre() + " - $" + robot.getPizzaEnOrden().getPrecio());
        } else {
            System.out.println("No has añadido una pizza.");
        }
        if (robot.getHeladoEnOrden() != null) {
            System.out.println("Helado: " + robot.getHeladoEnOrden().getDescripcion() + " - $" + robot.getHeladoEnOrden().getPrecio());
        } else {
            System.out.println("No has añadido un helado.");
        }
        int total = 0;
        if (robot.getPizzaEnOrden() != null) {
            total += robot.getPizzaEnOrden().getPrecio();
        }
        if (robot.getHeladoEnOrden() != null) {
            total += robot.getHeladoEnOrden().getPrecio();
        }
        System.out.println("Total: $" + total); 
    }

    //  transiciones de estado
    public void llamar(Robot robot) {
        System.out.println("ERROR: El robot ya está atendiendo.");
    }
    public void confirmarOrden(Robot robot) {
        System.out.println("Orden confirmada. Pasando a preparación...");
        robot.setEstado(robot.getEstadoPreparando());
        robot.preparar();
    }
    public void cancelarOrden(Robot robot) {
        System.out.println("Orden cancelada. Robocop volverá a dormir.");
        robot.setEstado(robot.getEstadoDormido());
    }
    public void preparar(Robot robot) {
        System.out.println("ERROR: No se puede preparar una nueva orden mientras se atiende a un cliente.");
    }
     public void entregar(Robot robot) {
        System.out.println("ERROR: La orden aún no ha sido preparada.");
    }
    
}