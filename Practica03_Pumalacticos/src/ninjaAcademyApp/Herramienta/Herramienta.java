package ninjaAcademyApp.Paquete.Herramienta;

/**
 * Interfaz que define lo que debe cumplir todas las herramientas por crear
 */
public interface Herramienta {
    
    /**
     * Obtiene el peso de la herramienta
     * @return peso de la herramienta
     */
    public double getPeso();

    /**
     * Obtiene el nombre de la herramienta
     * @return nombre de la herramienta
     */
    public String getNombre();

    /**
     * Obtiene la cantidad de herramientas disponibles
     * @return cantidad de herramientas
     */
    public int getCantidad();
    
}
