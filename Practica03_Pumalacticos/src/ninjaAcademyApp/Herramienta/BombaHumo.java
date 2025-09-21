package ninjaAcademyApp.Herramienta;

public class BombaHumo implements Herramienta {
    private int cantidad;

    public BombaHumo(int cantidad){
        this.cantidad = cantidad;
    }

    public double getPeso(){ return 0.460; } //kg
    public String getNombre(){ return "Bomba de humo"; }
    public int getCantidad(){ return cantidad; }
}
