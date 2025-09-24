package Paquete;

import java.util.ArrayList;
import java.util.List;

import Herramienta.Herramienta;

public class Paquete {
    List<Herramienta> herramientas;
    String nombre;

    public Paquete(List<Herramienta> herramientas, String nombre){
        this.herramientas = new ArrayList<>();
        this.herramientas.addAll(herramientas);
        this.nombre = nombre;
    }
    public double getPesoTotal(){
        double peso = 0;
        for (Herramienta herramienta : herramientas) {
            peso = peso + (herramienta.getPeso() * herramienta.getCantidad());
        }
        return peso;
    }

    public List<Herramienta> getHerramientas(){
        return herramientas;
    }

}
