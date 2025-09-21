package ninjaAcademyApp.Herramienta;

public class Kunai implements Herramienta {
    private int cantidad;

    public Kunai(int cantidad){
        this.cantidad = cantidad;
    }

    public double getPeso(){ return 0.20; } //kg
    public String getNombre(){ return "kunai"; }
    public int getCantidad(){ return cantidad; }
}
