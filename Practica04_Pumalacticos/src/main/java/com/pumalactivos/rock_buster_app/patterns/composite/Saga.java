package src.main.java.com.pumalactivos.rock_buster_app.patterns.composite;

import java.util.ArrayList;
import java.util.List;

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

    public String getNombre(){
        return nombre;
    }

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


    public int getDuracion(){
        int duracionTotal = 0;
        for (Component component : componentes) {
            duracionTotal = duracionTotal + component.getDuracion();
        }
        return duracionTotal;
    }

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

    public String getSinopsis(){
        return sinopsis;
    }

    public double getPrecioRenta(){
        double precioTotal = 0;
        for (Component component : componentes) {
            precioTotal = precioTotal + component.getPrecioRenta();
        }
        return precioTotal * .95;
    }
    
}
