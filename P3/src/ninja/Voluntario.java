package ninja;

public class Voluntario implements Ninja{
    private String nombre;
    private int edad;
    private String clan;
    private int nivel;
    private String rango;

    public Voluntario(String nombre, int edad, String clan, int nivel, String rango){
        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        this.nivel = nivel;
        this.rango = rango;

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

    public int getNivel(){
        return nivel;
    }
    
    public String getRango(){
        return rango;
    }
}
