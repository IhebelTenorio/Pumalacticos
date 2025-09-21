package ninjaAcademyApp.Herramienta;

public class Shuriken implements Herramienta {
    private int cantidad;

    public Shuriken(int cantidad){
        this.cantidad = cantidad;
    }

    public double getPeso(){ return 0.13; } //kg
    public String getNombre(){ return "Shuriken"; }
    public int getCantidad(){ return cantidad; }
}
