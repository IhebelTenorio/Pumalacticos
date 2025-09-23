package ninjaAcademyApp.Herramienta;

/**
 * Clase que representa una herramineta que implementa la interfaz Herramienta
 */
public class Botiquin implements Herramienta {
    private int cantidad;

    /**
     * Crea una nueva instancia de Botiquin con cierta cantidad especificada
     * @param cantidad cantidad de botiquines a crear
     */
    public Botiquin(int cantidad){
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el peso de un botiquin
     * @return peso de botiquin en kg 
     */
    public double getPeso(){ return 1.2; } //kg

    /**
     * Obtiene el nombre de la herramienta
     * @return nombre de la herramienta
     */
    public String getNombre(){ return "Botiquin"; }

    /**
     * Obtiene la cantidad de botiquines
     * @return cantidad de botiquines
     */
    public int getCantidad(){ return cantidad; }
}
