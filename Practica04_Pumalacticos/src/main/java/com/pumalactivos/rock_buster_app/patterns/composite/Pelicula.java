package src.main.java.com.pumalactivos.rock_buster_app.patterns.composite;

public class Pelicula implements Component {

    private String nombre;
    private String director;
    private int duracion;
    private String genero;
    private String sinopsis;
    private double precioRenta;

    public Pelicula(String nombre, String director, int duracion, String genero, String sinopsis, double precioRenta){
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.precioRenta = precioRenta;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDirector(){
        return director;
    }

    public int getDuracion(){
        return duracion;
    }

    public String getGenero(){
        return genero;
    }

    public String getSinopsis(){
        return sinopsis;
    }

    public double getPrecioRenta(){
        return precioRenta;
    }

}
