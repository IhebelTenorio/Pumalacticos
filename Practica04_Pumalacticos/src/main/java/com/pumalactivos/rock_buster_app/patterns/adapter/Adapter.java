package src.main.java.com.pumalactivos.rock_buster_app.patterns.adapter;

/**
 * Implementa el patrón Adapter para que un objeto 'Disco' pueda ser tratado
 * como un objeto 'Component' dentro del sistema RockBuster.
 * Traduce las llamadas de los métodos de la interfaz Component a los métodos
 * correspondientes de la clase Disco.
 */

import src.main.java.com.pumalactivos.rock_buster_app.patterns.composite.Component;

public class Adapter implements Component{
    private Disco adaptee;

     /**
     * Constructor que recibe el objeto a adaptar.
     * @param disco El objeto Disco que será adaptado.
     */
    public Adapter(Disco disco){
        this.adaptee = disco;
    }

    @Override
    public String getNombre(){
        return adaptee.getNombre();
    }

    /**
     * Adapta la llamada getDirector() a getArtista(), ya que un disco
     * no tiene director, sino artista.
     */
    @Override
    public String getDirector(){
        return adaptee.getArtista();
    }

    /**
     * Los discos no tienen duración en este sistema, por lo que se devuelve 0.
     */
    @Override
    public int getDuracion(){
        return 0; // No aplica para discos.
    }

    @Override
    public String getGenero(){
        return adaptee.getGenero();
    }

    @Override
    public String getSinopsis(){
        return adaptee.getNombre() + " es un disco de " + adaptee.getArtista() + ", parte del catálogo de Mixdown. Lanzado en " + adaptee.getEstreno() + ".";
    }

    /**
     * Adapta el precio de venta del disco al concepto de precio de renta.
     */
    @Override
    public double getPrecioRenta(){
        return adaptee.getPrecioVenta();
    }
    
}
