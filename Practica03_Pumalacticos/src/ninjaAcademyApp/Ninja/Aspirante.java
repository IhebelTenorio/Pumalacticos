package ninjaAcademyApp.Ninja;

public class Aspirante extends Konoha {

    public Aspirante(String nombre, int edad, String clan, int nivelHabilidad){
        super(nombre, edad, clan, nivelHabilidad);
    }
    
    public String toString() {
        return super.toString() + " Aspirante";
    }
}