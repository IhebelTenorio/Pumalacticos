package ninjaAcademyApp.Paquete;

import java.util.ArrayList;
import java.util.List;

import ninjaAcademyApp.Herramienta.Herramienta;

public class Paquete {
    private List<Herramienta> herramientas;

    public Paquete(List<Herramienta> herramientas){
        this.herramientas = new ArrayList<>();
        this.herramientas.addAll(herramientas);
    }

    public List<Herramienta> getHerramientas() {
        return herramientas;
    }

    protected void agregarHerramienta(Herramienta h){
        herramientas.add(h);
    }
}
