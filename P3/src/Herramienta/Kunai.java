package Herramienta;

/**
 * Clase que representa una herramienta que implementa la interfaz Herramienta
 */
public class Kunai implements Herramienta {
    private int cantidad;

    /**
     * Crea una nueva instancia de Kunai con cierta cantidad especificada
     * @param cantidad cantidad de kunais por crear
     */
    public Kunai(int cantidad){
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el peso de una kunai
     * @return peso del kunai en kg
     */
    public double getPeso(){ return 0.20; } //kg

    /**
     * Obtiene el nombre de la herramienta
     * @return nombre de la herramienta
     */
    public String getNombre(){ return "kunai"; }

    /**
     * Obtiene la cantidad de kunais 
     * @return cantidad de kunais
     */
    public int getCantidad(){ return cantidad; }
}
