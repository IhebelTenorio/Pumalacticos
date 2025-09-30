package src.main.java.com.pumalactivos.rock_buster_app.patterns.composite;

public class Pelicula implements Component {

    private String nombre;
    private String director;
    private int duracion;
    private String genero;
    private String sinopsis;
    private double precioRenta;

    /**
     * Constructor para crear una nueva Película.
     * @param nombre El nombre de la película.
     * @param director El director de la película.
     * @param duracion La duración en minutos.
     * @param genero El género de la película.
     * @param sinopsis Una breve descripción de la película.
     * @param precioRenta El costo de renta.
     */

    public Pelicula(String nombre, String director, int duracion, String genero, String sinopsis, double precioRenta){
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.precioRenta = precioRenta;
    }

    @Override
    public String getNombre(){
        return nombre;
    }

    @Override
    public String getDirector(){
        return director;
    }

    @Override
    public int getDuracion(){
        return duracion;
    }

    @Override
    public String getGenero(){
        return genero;
    }

    @Override
    public String getSinopsis(){
        return sinopsis;
    }

    @Override
    public double getPrecioRenta(){
        return precioRenta;
    }

}
