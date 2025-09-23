package ninjaAcademyApp.Campo;

/**
 * Clase abstracta que defina la estructura base para los campos de batalla
 */
public abstract class CampoBatalla {
    protected String nombre;

    /**
     * Ibtiene el nombre del campo de batalla
     * @return nombre del campo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Regresa una cadena de texto del campo de batalla
     * @return una cadena de texto concatenada con el nombre del campo de batalla
     */
    public String toString() {
        return "Campo Asignado: " + nombre;
    }   
}
