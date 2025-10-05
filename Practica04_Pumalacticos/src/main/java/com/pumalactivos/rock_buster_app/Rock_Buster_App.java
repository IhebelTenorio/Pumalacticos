package com.pumalactivos.rock_buster_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.pumalactivos.rock_buster_app.patterns.adapter.Adapter;
import com.pumalactivos.rock_buster_app.patterns.adapter.Disco;
import com.pumalactivos.rock_buster_app.patterns.composite.Component;
import com.pumalactivos.rock_buster_app.patterns.composite.Pelicula;
import com.pumalactivos.rock_buster_app.patterns.composite.Saga;

/**
 * Clase principal que actúa como cliente de los patrones Composite y Adapter.
 * Contiene el menú interactivo para que el usuario explore el catálogo de RockBuster.
 */

public class Rock_Buster_App {
    private static Scanner sc = new Scanner(System.in);
    private static Saga catalogo = inicializarCatalogo();

    public static void main(String[] args){
         System.out.println("Bienvenido a RockBuster");
        menuPrincipal();
        System.out.println("¡Vuelve pronto a RockBuster!");
    }
    
    /**
     * Crea y ensambla el catálogo completo de productos de la tienda.
     * @return La saga raíz que contiene todos los productos.
     */
    private static Saga inicializarCatalogo() {
        Saga catalogo = new Saga("Catalogo de RockBuster", "No deberias poder leer esto");

        //Peliculas saga Cosmere
        Saga cosmere = new Saga("Cosmere", "Un universo con diversos planetas y sistemas de magia con un origen en comun");
            Saga nacidosDeLaBruma = new Saga("Nacidos de la Bruma", "En el planeta Scadriel se lleva a cabo la historia de los alomantes, ferroquimistas y hemalurgicos");
                Saga primeraEra = new Saga("Primera Era", "Cuenta la historia de Vin y la banda de Kelsier");
                    primeraEra.addContenido(new Pelicula("El Imperio Final", "Brandon Sanderson", 124, "Fantasía", "Libro 1 de Mistborn, el Lord Legislador lleva governando 1000 años", 40.50));
                    primeraEra.addContenido(new Pelicula("El Pozo de la Ascención", "Brandon Sanderson", 144, "Fantasía", "Libro 2 de Mistborn, se puso dura la cosa en Luthadel", 48.75));
                    primeraEra.addContenido(new Pelicula("El Héroe de las eras", "Brandon Sanderson", 113, "Fantasía", "Libro 3 de Mistborn, Ahora se puso dura la cosa con entidades superiores", 55.25));
                nacidosDeLaBruma.addContenido(primeraEra); // Añadimos la saga de la primera era a Nacidos de la Bruma
                nacidosDeLaBruma.addContenido(new Pelicula("Historia Secreta", "Brandon Sanderson", 87, "Fantasía", "Spin-off de la Saga, no pertenece a ninguna era", 38.35));
            cosmere.addContenido(nacidosDeLaBruma); // Añadimos Nacidos de la Bruma a Cosmere
            cosmere.addContenido(new Pelicula("Elantris", "Brandon Sanderson", 134, "Fantasía", "En el planeta Cel el principe Raoden de Arelon es alcanzado por la Shaod el dia de su boda", 20));

        // Películas individuales
        Pelicula elRoboDelSiglo = new Pelicula("El Robo del Siglo", "Ariel Winograd", 114, "Crimen", "Basada en el robo real al Banco Río.", 40.00);
        Pelicula parasite = new Pelicula("Parásitos", "Bong Joon-ho", 132, "Suspenso", "Una familia pobre se infiltra en la vida de una familia rica.", 45.00);
        Pelicula interstellar = new Pelicula("Interstellar", "Christopher Nolan", 169, "Ciencia Ficción", "Un grupo de exploradores viaja a través del espacio para salvar la Tierra", 50.00);
        Pelicula inception = new Pelicula("Inception", "Christopher Nolan", 148, "Ciencia Ficción", "Un ladrón que roba secretos a través de los sueños es dado la tarea de implantar una idea en la mente de un CEO.", 55.00);

        //Discos Mixdown
        Disco zoeUnplugged = new Disco("Zoé Unplugged", "Zoé", "Alternativo", 2011, 250);
        Disco finisterra = new Disco("Finisterra", "Mago de Oz", "Rock", 2000, 300);


        //Ensamblaje del catálogo
        catalogo.addContenido(cosmere);
        catalogo.addContenido(elRoboDelSiglo);
        catalogo.addContenido(parasite);
        catalogo.addContenido(interstellar);
        catalogo.addContenido(inception);
        catalogo.addContenido(new Adapter(zoeUnplugged));
        catalogo.addContenido(new Adapter(finisterra));

        return catalogo;
    }
        
    /**
     * Muestra el menú principal y gestiona la interacción del usuario.
     */
    private static void menuPrincipal() {
        String opcion;
        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Ver catálogo completo");
            System.out.println("2. Filtrar por género");
            System.out.println("3. Filtrar por precio máximo");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    mostrarCatalogo(catalogo.getComponentes());
                    break;
                case "2":
                    menuFiltrarPorGenero();
                    break;
                case "3":
                    menuFiltrarPorPrecio();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (!opcion.equals("4"));
    }

    /**
     * Muestra una lista de productos y permite al usuario ver los detalles de uno.
     * @param productos La lista de componentes a mostrar.
     */
    private static void mostrarCatalogo(List<Component> productos) {
        if (productos.isEmpty()) {
            System.out.println("No se encontraron productos con ese criterio.");
            return;
        }

        System.out.println("\nCatálogo de Productos ");
        for (int i = 0; i < productos.size(); i++) {
            Component p = productos.get(i);
            String tipo = (p instanceof Saga) ? "[SAGA]" : "[INDIVIDUAL]";
            System.out.printf("%d. %-10s %-30s $%.2f\n", i + 1, tipo, p.getNombre(), p.getPrecioRenta());
        }

        System.out.print("\nSelecciona un producto para ver detalles (o presiona Enter para volver): ");
        String seleccion = sc.nextLine();
        try {
            int index = Integer.parseInt(seleccion) - 1;
            if (index >= 0 && index < productos.size()) {
                mostrarDetalles(productos.get(index));
            }
        } catch (NumberFormatException e) {
            // No hacer nada, volver al menú
        }
    }
    
    /**
     * Pide al usuario un género y muestra los productos que coinciden.
     */
    private static void menuFiltrarPorGenero() {
        List<String> generos = obtenerGenerosUnicos();

        System.out.println("\nSelecciona un Género");
        for (int i = 0; i < generos.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, generos.get(i));
        }
        System.out.print("\nElige una opción (o presiona Enter para volver): ");
        
        try {
            String seleccionStr = sc.nextLine();
            if (seleccionStr.isEmpty()) {
                return; // Volver al menú principal si no se ingresa nada
            }

            int seleccion = Integer.parseInt(seleccionStr) - 1;
            if (seleccion >= 0 && seleccion < generos.size()) {
                String generoSeleccionado = generos.get(seleccion);
                System.out.println("\nMostrando productos del género: " + generoSeleccionado + "\n");

                List<Component> todos = catalogo.getContenido();
                List<Component> filtrados = new ArrayList<>();
                for (Component p : todos) {
                    if (p.getGenero().equalsIgnoreCase(generoSeleccionado)) {
                        filtrados.add(p);
                    }
                }
                mostrarCatalogo(filtrados);
            } else {
                System.out.println("Opción no válida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, introduce un número.");
        }
    }
    
    /**
     * Recorre el catálogo y devuelve una lista de todos los géneros
     * existentes sin repeticiones.
     * @return Una lista de Strings con los géneros únicos.
     */
    private static List<String> obtenerGenerosUnicos() {
        return catalogo.getContenido().stream()         // Convierte la lista en un "stream" para procesarla
                       .map(Component::getGenero)       // Toma solo el género de cada componente
                       .distinct()                      // Elimina los duplicados
                       .sorted()                        // Ordena alfabéticamente
                       .collect(Collectors.toList());   // Convierte el resultado de nuevo en una lista
    }
    
    /**
     * Pide al usuario un precio máximo y muestra los productos que no lo superan.
     */
    private static void menuFiltrarPorPrecio() {
        System.out.print("Introduce el precio máximo: ");
        try {
            double precio = Double.parseDouble(sc.nextLine());
            List<Component> todos = catalogo.getContenido();
            List<Component> filtrados = new ArrayList<>();
            for (Component p : todos) {
                if (p.getPrecioRenta() <= precio) {
                    filtrados.add(p);
                }
            }
            mostrarCatalogo(filtrados);
        } catch (NumberFormatException e) {
            System.out.println("Precio no válido.");
        }
    }

    /**
     * Muestra toda la información de un componente seleccionado.
     * @param p El componente del cual mostrar detalles.
     */
    private static void mostrarDetalles(Component p) {
        System.out.println("\nDETALLES DEL PRODUCTO");
        System.out.println("Nombre: " + p.getNombre());
        System.out.printf("Precio de Renta: $%.2f\n", p.getPrecioRenta());
        System.out.println("Sinopsis: " + p.getSinopsis());
        
        // Si es una Saga
        if (p instanceof Saga) {
            System.out.println("Duración Total: " + p.getDuracion() + " min.");
            System.out.println("\nContenido de la Saga");
            List<Component> contenidoSaga = ((Saga) p).getContenido(); 
            for(Component item : contenidoSaga) {
                System.out.println("- " + item.getNombre());
            }
        } else { // Si es Pelicula o Disco
            System.out.println("Director/Artista: " + p.getDirector());
            System.out.println("Género: " + p.getGenero());
            if (p.getDuracion() > 0) {
                System.out.println("Duración: " + p.getDuracion() + " min.");
            }
        }

        System.out.println("                   ");
        System.out.print("Presiona Enter para continuar...");
        sc.nextLine();
    }
}
