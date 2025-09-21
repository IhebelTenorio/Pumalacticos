package ninjaAcademyApp.Ninja;

public class Voluntario implements Ninja{
    private String nombre;
    private int edad;
    private String clan;
    private int habilidad;
    
    public Voluntario(String nombre, int edad, String clan, int habilidad){
        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        this.habilidad = habilidad;
    }


    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public String getClan(){
        return clan;
    }
    public int getHabilidad(){
        return habilidad;
    }
    
}
