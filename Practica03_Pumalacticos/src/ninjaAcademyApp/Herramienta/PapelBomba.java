package ninjaAcademyApp.Herramienta;

public class PapelBomba implements Herramienta {
    private int cantidad;

    public PapelBomba(int cantidad){
        this.cantidad = cantidad;
    }

    public double getPeso(){ return 0.16; } //kg
    public String getNombre(){ return "Papel bomba"; }
    public int getCantidad(){ return cantidad; }
}
