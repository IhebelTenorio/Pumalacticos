package com.pumalactivos.rock_buster_app.patterns.adapter;

/**
 * Implementa el patrón Adapter para que un objeto 'Disco' pueda ser tratado
 * como un objeto 'Component' dentro del sistema RockBuster.
 * Traduce las llamadas de los métodos de la interfaz Component a los métodos
 * correspondientes de la clase Disco.
 */

import com.pumalactivos.rock_buster_app.patterns.composite.Component;

public class Adapter implements Component{
    private Disco adaptee;

     /**
     * Constructor que recibe el objeto a adaptar.
     * @param disco El objeto Disco que será adaptado.
     */
    public Adapter(Disco disco){
        this.adaptee = disco;
    }

    /**
     * Regresa el nombre del disco
     * @return el nombre del disco 
     */
    @Override
    public String getNombre(){
        return adaptee.getNombre();
    }

    /**
     * Adapta la llamada getDirector() a getArtista(), ya que un disco
     * no tiene director, sino artista.
     * @return el nombre del artista del disco
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

    /**
     * Regresa e género del disco
     * @return el género del disco
     */
    @Override
    public String getGenero(){
        return adaptee.getGenero();
    }

    /**
     * Regresa una pequeña sipnosis del disco, contiene nombre del disco, el artista y año de estreno
     * @return una cadena de texto de la sipnosis
     */
    @Override
    public String getSinopsis(){
        return adaptee.getNombre() + " es un disco de " + adaptee.getArtista() + ", parte del catálogo de Mixdown. Lanzado en " + adaptee.getEstreno() + ".";
    }

    /**
     * Adapta el precio de venta del disco al concepto de precio de renta.
     * @return precio de venta del disco 
     */
    @Override
    public double getPrecioRenta(){
        return adaptee.getPrecioVenta();
    }
    
}
