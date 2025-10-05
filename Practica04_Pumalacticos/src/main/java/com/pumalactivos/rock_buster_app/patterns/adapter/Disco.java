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

    /**
     * Regresa el nombre del disco 
     * @return nombre del disco
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Regresa el nombre del artista o banda
     * @return nombre del artista/banda
     */
    public String getArtista(){
        return artista;
    }

    /**
     * Regresa el géenro del disco
     * @return género del disco 
     */
    public String getGenero(){
        return genero;
    }

    /**
     * Regresa el año del lanzamiento del disco 
     * @return año de estreno
     */
    public int getEstreno(){
        return estreno;
    }

    /**
     * Regresa el precio del disco
     * @return precio del disco
     */
    public int getPrecioVenta(){
        return precioVenta;
    }
}
