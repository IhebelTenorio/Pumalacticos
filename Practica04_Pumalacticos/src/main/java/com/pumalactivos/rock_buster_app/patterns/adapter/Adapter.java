package src.main.java.com.pumalactivos.rock_buster_app.patterns.adapter;

import src.main.java.com.pumalactivos.rock_buster_app.patterns.composite.Component;

public class Adapter implements Component{
    private Disco adaptee;

    public Adapter(Disco disco){
        this.adaptee = disco;
    }

    public String getNombre(){
        return adaptee.getNombre();
    }

    public String getDirector(){
        return adaptee.getArtista();
    }
    
    public int getDuracion(){
        return 0;
    }

    public String getGenero(){
        return adaptee.getGenero();
    }

    public String getSinopsis(){
        return adaptee.getNombre() + " es un Disco a la venta parte del catalogo de Mixdown";
    }

    public double getPrecioRenta(){
        return adaptee.getPrecioVenta();
    }
    
}
