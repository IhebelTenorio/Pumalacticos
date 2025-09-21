package ninjaAcademyApp.Herramienta;

public class Botiquin implements Herramienta {
    private int cantidad;

    public Botiquin(int cantidad){
        this.cantidad = cantidad;
    }

    public double getPeso(){ return 1.2; } //kg
    public String getNombre(){ return "Botiquin"; }
    public int getCantidad(){ return cantidad; }
}
