package ninjaAcademyApp.Ninja;

public class Voluntario extends Konoha {
    private String rango;
    
    public Voluntario(String nombre, int edad, String clan, int nivelHabilidad, String rango){
        super(nombre, edad, clan, nivelHabilidad);
        this.rango = rango;
    }


    public String getRango(){
        return rango;
    }
    
    public String toString() {
        return super.toString() + " Voluntario [rango=" + rango + "]";
    }   
    
}
