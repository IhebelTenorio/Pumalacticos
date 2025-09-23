package ninjaAcademyApp.Ninja;

/**
 * Interfaz que define lo básico que deben tener todas las clases que representen a un ninja
 */
public interface Ninja {

    /**
     * Obtiene el nombre del ninja
     * @return nombre del ninja
     */
    public String getNombre();

    /**
     * Obtiene la edad del ninja
     * @return edad del ninja
     */
    public int getEdad();

    /**
     * Obtiene el clan de origen del ninja
     * @return clan del ninja
     */
    public String getClan();

    /**
     * Obtiene el nivel de habilidad del ninja
     * @return nivel de habilidad del ninja
     */
    public int getHabilidad();
    
}
