package ninja;

public class Aspirante implements Ninja {
    private String nombre;
    private int edad;
    private String clan;
    private int nivel;

    public Aspirante(String nombre, int edad, String clan, int nivel){
        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getClan() {
        return clan;
    }
    
    public int getNivel() {
        return nivel;
    }

}
