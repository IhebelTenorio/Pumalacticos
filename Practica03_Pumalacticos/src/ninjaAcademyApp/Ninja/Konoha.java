//Creamos esta clase para no repetir codigo y agrupar caracteristicas de los ninjas
package ninjaAcademyApp.Ninja;

/**
 * Clase abstracta que srive como base para los ninjas, estableciendo sus atributos y comportamientos
 */
public abstract class Konoha {
    protected String nombre;
    protected int edad;
    protected String clan;
    protected int nivelHabilidad;

    /**
     * Constructor de la clase Konoha
     * @param nombre nombre del ninja
     * @param edad edad del ninja
     * @param clan clan de origen del ninja 
     * @param nivelHabilidad nivel de habilidad del ninja
     */
    public Konoha(String nombre, int edad, String clan, int nivelHabilidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        this.nivelHabilidad = nivelHabilidad;
    }

    /**
     * Obtiene el nombre del ninja
     * @return nombre del ninja
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el clan del ninja
     * @return clan del ninja
     */
    public String getClan() {
        return clan;
    }

    /**
     * Obtiene la edad del ninja
     * @return edad del ninja
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el nivel de habilidad del ninja 
     * @return nivel de habilidad del ninja
     */
    public int getNivelHabilidad() {
        return nivelHabilidad;
    }

    /**
     * Regresa los atributos principales del ninja
     * @return cadena de texto concatenada con nombre, edad, clan y nivel de habilidad
     */
    public String toString() {
        return "Ninja [nombre=" + nombre + ", edad=" + edad + ", clan=" + clan + ", nivelHabilidad=" + nivelHabilidad + "]";
    }   
}
