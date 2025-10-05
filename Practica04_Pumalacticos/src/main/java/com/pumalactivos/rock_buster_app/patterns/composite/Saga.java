package com.pumalactivos.rock_buster_app.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una colección de elementos que pueden ser películas, discos u otras sagas que implementa la interfaz Component
 */
public class Saga implements Component {
    private String nombre;
    private List<Component> componentes;
    private String sinopsis;

        /**
     * Constructor para crear una nueva Saga.
     * @param nombre El nombre de la saga.
     * @param sinopsis Una breve descripción de la saga.
     */
    public Saga(String nombre, String sinopsis){
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
        this.sinopsis = sinopsis;
    }

    /**
     * Regresa todo el contenido de una saga con todos los elementos de niveles inferiores, es decir, las sub-sagas
     * @return una lista con todos los componentes cintenidos recursivamente 
     */
    public List<Component> getContenido(){ // devuelve todo el contenido (tambien de nodos inferiores)
        List<Component> contenidoTotal = new ArrayList<>();
        // Agregamos hoja por hoja el contenido, si no es una hoja, agregamos las hojas del arbol.
        for (Component component : componentes) {
            if(component instanceof Saga){
                contenidoTotal.addAll(((Saga) component).getContenido());
            } else {
                contenidoTotal.add(component);
            }
        }
        return contenidoTotal;
    }

    /**
     * Regresa todoso los componentes de una saga y sub-sagas el cuál su género es igual al que se pide
     * @param genero el género que se desea filtrar
     * @return una lista de componentes el cuál su género es igual al que se pide
     */
    public List<Component> getContenidoGenero(String genero){ // Este metodo es para filtrar por genero
        List<Component> contenidoTotal = getContenido();
        List<Component> contenidoPorGenero = new ArrayList<>();
        if(contenidoTotal.size()==0){
            return contenidoPorGenero;
        }
        for(Component component: contenidoTotal){
            if(component.getGenero().equals(genero)){
                contenidoPorGenero.add(component);
            }
        }
        return contenidoPorGenero;
    }

    /**
     * Regresa todos los componentes de una saga y sub-sagas el cuál su precio de renta es meno o igual a un precio especificado
     * @param precioMax precio máximo que se permite
     * @return una lista con elementos con su precio de renta menor o igual al especificado 
     */
    public List<Component> getContenidoPrecio(double precioMax){ // Este metodo es para filtrar por genero
        List<Component> contenidoTotal = getContenido();
        List<Component> contenidoPorPrecio = new ArrayList<>();
        if(contenidoTotal.size()==0){
            return contenidoPorPrecio;
        }
        for(Component component: contenidoTotal){
            if(component.getPrecioRenta() <= precioMax){
                contenidoPorPrecio.add(component);
            }
        }
        return contenidoPorPrecio;
    }

    /**
     * Añade un componente (Pelicula o Saga) a esta saga.
     * @param component El componente a agregar.
     */
    public void addContenido(Component component){
        componentes.add(component);
    }

    /**
     * Regresa el nombre de la saga
     * @return nombre de la saga
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Regresa el director de la saga en base a 3 parametros, si la saga esta vacia regresa NA, si todos los elementos tienen el mismo director
     * regresa el nombre del director y si hay varios diferentes regresa que son múltipes directores
     * @return nombre del director o un texto que diga que son varios
     */
    public String getDirector(){
        if(componentes.size()==0){
            return "NA";
        }
        // checamos si todos los directores del contenido son el mismo, si si, devolvemos ese
        // si no, devolvemos "multiples directores"
        for(int i = 0; i<componentes.size()-1; i++){
            if(!componentes.get(i).getDirector().equals(componentes.get(i+1).getDirector())){
                return "Multiples Directores";
            }
        }
        return componentes.get(0).getDirector();
    }

    /**
     * Calcula la duración total de una saga sumando la duración de cada película
     * @return la duración total en minutos 
     */
    public int getDuracion(){
        int duracionTotal = 0;
        for (Component component : componentes) {
            duracionTotal = duracionTotal + component.getDuracion();
        }
        return duracionTotal;
    }

    /**
     * Determina el género principal de una saga en base a 3 parámetros, si la saga está vacía regresa NA, si todas las películas tienen el mísmo 
     * género regresa ese género y si hay varios diferentes géneros regresa que son múltiples géneros
     * @returnel género principal o si hay varios géneros
     */
    public String getGenero(){
        if(componentes.size()==0){
            return "NA";
        }
        // checamos si todos los generos del contenido son el mismo, si si, devolvemos ese
        // si no, devolvemos "multiples géneros"
        for(int i = 0; i<componentes.size()-1; i++){
            if(!componentes.get(i).getGenero().equals(componentes.get(i+1).getGenero())){
                return "Multiples Géneros";
            }
        }
        return componentes.get(0).getGenero();
    }

    /**
     * Regresa la sipnosis de la saga
     * @return una sipnosis 
     */
    public String getSinopsis(){
        return sinopsis;
    }

    /**
     * Calcula el precio total de renta de la saga sumando los precios de las películas y con un descuento del 5%
     * @return el precio total de renta con un descuento 
     */
    public double getPrecioRenta(){
        double precioTotal = 0;
        for (Component component : componentes) {
            precioTotal = precioTotal + component.getPrecioRenta();
        }
        return precioTotal * .95;
    }

    /**
 * Devuelve la lista de componentes directos (hijos) de esta saga.
 * @return La lista de componentes de primer nivel dentro de la saga.
 */
    public List<Component> getComponentes() {
    return componentes;
    }
    
}
