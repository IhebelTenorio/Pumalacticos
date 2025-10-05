package com.pumalactivos.rock_buster_app.patterns.composite;

/**
 * Define el contrato del arbol que representará a las películas y sagas
 * Esta es la interfaz Component del patrón Composite, que permite tratar
 * a los objetos individuales (Pelicula) y a las composiciones (Saga) de
 * manera uniforme.
 */
public interface Component {

    /**
     * Devuelve el nombre del componente.
     * @return El nombre del producto.
     */
    public String getNombre();

     /**
     * Devuelve el director de la película o un resumen para una saga.
     * @return El nombre del director o directores.
     */
    public String getDirector();

    /**
     * Devuelve la duración en minutos de la película o la suma de las duraciones
     * de todas las películas en la saga.
     * @return La duración total en minutos.
     */
    public int getDuracion();

    /**
     * Devuelve el género de la película o saga.
     * @return El género de la película o saga.
     */
    public String getGenero();

    /**
     * Devuelve la sinopsis de la película o una descripción general de la saga.
     * @return La sinopsis de la película o las sinopsis para una saga.
     */
    public String getSinopsis();

    /**
     * Devuelve el precio de renta. Para una saga, incluye un descuento.
     * @return El precio total de renta.
     */
    public double getPrecioRenta();
}
