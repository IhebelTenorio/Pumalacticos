package com.pumalactivos.rock_buster_app.patterns.composite;

public class Pelicula implements Component {

    private String nombre;
    private String director;
    private int duracion;
    private String genero;
    private String sinopsis;
    private double precioRenta;

    /**
     * Constructor para crear una nueva Película.
     * @param nombre El nombre de la película.
     * @param director El director de la película.
     * @param duracion La duración en minutos.
     * @param genero El género de la película.
     * @param sinopsis Una breve descripción de la película.
     * @param precioRenta El costo de renta.
     */

    public Pelicula(String nombre, String director, int duracion, String genero, String sinopsis, double precioRenta){
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.precioRenta = precioRenta;
    }

    /**
     * Regresa el nombre de la película
     * @return nombre de la pelicula 
     */
    @Override
    public String getNombre(){
        return nombre;
    }

    /**
     * Regresa el nombre del director de la película
     * @return nombre del director 
     */
    @Override
    public String getDirector(){
        return director;
    }

    /**
     * Regresa la duración de la película
     * @return duración de la película
     */
    @Override
    public int getDuracion(){
        return duracion;
    }

    /**
     * Regresa el género de la película
     * @return género de la película
     */
    @Override
    public String getGenero(){
        return genero;
    }

    /**
     * Regresa la sipnosis de la película
     * @return una sipnosis de la película 
     */
    @Override
    public String getSinopsis(){
        return sinopsis;
    }

    /**
     * Obtiene el precio de la renta de una película 
     * @return el costo de renta 
     */
    @Override
    public double getPrecioRenta(){
        return precioRenta;
    }

}
