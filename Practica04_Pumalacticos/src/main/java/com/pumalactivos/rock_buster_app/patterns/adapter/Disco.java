package src.main.java.com.pumalactivos.rock_buster_app.patterns.adapter;

/**
 * Representa un Disco de la tienda Mixdown.
 * Esta es la clase 'Adaptee' en el patrón Adapter. Su interfaz es
 * incompatible con la interfaz 'Component' que nuestro sistema RockBuster espera.
 */

public class Disco {
    private String nombre;
    private String artista;
    private String genero;
    private int estreno;
    private int precioVenta;

    /**
     * Constructor para un nuevo Disco.
     * @param nombre El nombre del álbum.
     * @param artista El artista o banda.
     * @param genero El género musical.
     * @param estreno El año de lanzamiento.
     * @param precioVenta El precio de venta del disco.
     */

    public Disco(String nombre, String artista, String genero, int estreno, int precioVenta){
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.estreno = estreno;
        this.precioVenta = precioVenta;
    }

    public String getNombre(){
        return nombre;
    }

    public String getArtista(){
        return artista;
    }

    public String getGenero(){
        return genero;
    }

    public int getEstreno(){
        return estreno;
    }

    public int getPrecioVenta(){
        return precioVenta;
    }
}
