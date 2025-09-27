package src.main.java.com.pumalactivos.rock_buster_app;

import src.main.java.com.pumalactivos.rock_buster_app.patterns.composite.Pelicula;
import src.main.java.com.pumalactivos.rock_buster_app.patterns.composite.Saga;

public class Rock_Buster_App {
    public static void main(String[] args){

        // Vamos a hacer la estructura poco a poco xd
        // Yo voy a poner unos libros, pero los pondremos como si fueran pelis, es que el Cosmere fue la unica saga
        // que conozco que tiene sagas y sagas dentro de otras.
        // Voy a dejar un TXT del arbol de esto para que sea más claro al programar y testear
        // El arbol lo podemos actualizar con IA para nosotros, pero hay que borrar estos comentarios xD

        Saga catalogo = new Saga("Catalogo de RockBuster", "No deberias poder leer esto");
        Saga cosmere = new Saga("Cosmere", "Un universo con diversos planetas y sistemas de magia con un origen en comun");
            Saga nacidosDeLaBruma = new Saga("Nacidos de la Bruma", "En el planeta Scadriel se lleva a cabo la historia de los alomantes, ferroquimistas y hemalurgicos");
                Saga primeraEra = new Saga("Primera Era", "Cuenta la historia de Vin y la banda de Kelsier");
                    Pelicula elImperioFinal = new Pelicula("El Imperio Final", "Brandon Sanderson", 124, "Fantasía", "Libro 1 de Mistborn, el Lord Legislador lleva governando 1000 años", 40.50);
                    Pelicula elPozoDA = new Pelicula("El Pozo de la Ascención", "Brandon Sanderson", 144, "Fantasía", "Libro 2 de Mistborn, se puso dura la cosa en Luthadel", 48.75);
                    Pelicula elHeroeDLE = new Pelicula("El Héroe de las eras", "Brandon Sanderson", 113, "Fantasía", "Libro 3 de Mistborn, Ahora se puso dura la cosa con entidades superiores", 55.25);
                Pelicula historiaSecreta = new Pelicula("Historia Secreta", "Brandon Sanderson", 87, "Fantasía", "Spin-off de la Saga, no pertenece a ninguna era", 38.35);
            Pelicula elantris = new Pelicula("Elantris", "Brandon Sanderson", 134, "Fantasía", "En el planeta Cel el principe Raoden de Arelon es alcanzado por la Shaod el dia de su boda", 20);
        


        // Hay que ensamblar esto xd
        catalogo.addContenido(cosmere);
        cosmere.addContenido(nacidosDeLaBruma);
            nacidosDeLaBruma.addContenido(primeraEra);
                primeraEra.addContenido(elImperioFinal);
                primeraEra.addContenido(elPozoDA);
                primeraEra.addContenido(elHeroeDLE);
            nacidosDeLaBruma.addContenido(historiaSecreta);
        cosmere.addContenido(elantris);

        


    }    
}
