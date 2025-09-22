//Creamos esta clase para no repetir codigo y agrupar caracteristicas de los ninjas
package ninjaAcademyApp.Ninja;

public abstract class Konoha {
    protected String nombre;
    protected int edad;
    protected String clan;
    protected int nivelHabilidad;

    public Konoha(String nombre, int edad, String clan, int nivelHabilidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        this.nivelHabilidad = nivelHabilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClan() {
        return clan;
    }

    public int getEdad() {
        return edad;
    }

    public int getNivelHabilidad() {
        return nivelHabilidad;
    }

    public String toString() {
        return "Ninja [nombre=" + nombre + ", edad=" + edad + ", clan=" + clan + ", nivelHabilidad=" + nivelHabilidad + "]";
    }   
}
