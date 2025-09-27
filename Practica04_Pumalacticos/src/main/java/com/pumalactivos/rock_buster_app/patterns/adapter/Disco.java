package src.main.java.com.pumalactivos.rock_buster_app.patterns.adapter;

public class Disco {
    private String nombre;
    private String artista;
    private String genero;
    private int estreno;
    private int precioVenta;

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
