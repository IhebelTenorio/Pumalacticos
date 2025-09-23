package Herramienta;

/**
 * Clase que representa una herramienta que implementa la interfaz Herramienta
 */
public class BombaHumo implements Herramienta {
    private int cantidad;

    /**
     * Crea una nueva instancia de BombaHumo con una cantidad especifica
     * @param cantidad cantidad de bombas de humo
     */
    public BombaHumo(int cantidad){
        this.cantidad = cantidad;
    }

    /**
     * obtiene el peso de una bomba de humo
     * @return peso de la bomba en kg
     */
    public double getPeso(){ return 0.460; } //kg

    /**
     * Obtiene el nombre de la herramineta
     * @return nombre de la herramienta
     */
    public String getNombre(){ return "Bomba de humo"; }

    /**
     * Obtiene la cantidad de bombas de humo disponibles
     * @return cantidad de bombas de humo
     */
    public int getCantidad(){ return cantidad; }
}
