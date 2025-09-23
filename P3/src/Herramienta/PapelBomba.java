package Herramienta;

/**
 * Clase que representa una herramienta que implementa la interfaz Herramienta
 */
public class PapelBomba implements Herramienta {
    private int cantidad;

    /**
     * Crea una nueva instancia de PapelBomba con cierta cantidad especifica
     * @param cantidad cantidad de papel bomba por hacer
     */
    public PapelBomba(int cantidad){
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el peso de un papel bomba
     * @return peso de un papel bomba en kg
     */
    public double getPeso(){ return 0.16; } //kg

    /**
     * Obtiene el nombre de la herramienta
     * @return nombre de la herramienta
     */
    public String getNombre(){ return "Papel bomba"; }

    /**
     * Obtiene la cantidad de papeles bomba 
     * @return cantidad de papeles bomba
     */
    public int getCantidad(){ return cantidad; }
}
