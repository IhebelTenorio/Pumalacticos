package Herramienta;

/**
 * Clase que representa una herramienta que implementa la interfaz Herramienta
 */
public class Shuriken implements Herramienta {
    private int cantidad;

    /**
     * Crea una instancia de Shurikem con cierta cantidad especifica
     * @param cantidad cantidad de shirkens a crear
     */
    public Shuriken(int cantidad){
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el peso de una shuriken 
     * @return peso de una shuriken en kg
     */
    public double getPeso(){ return 0.13; } //kg

    /**
     * Obtiene el nombre de la herramienta 
     * @return nombre de la herramienta
     */
    public String getNombre(){ return "Shuriken"; }

    /**
     * Obtiene la cantidad de shurikens 
     * @return cantidad de shirkens que hay
     */
    public int getCantidad(){ return cantidad; }
}
