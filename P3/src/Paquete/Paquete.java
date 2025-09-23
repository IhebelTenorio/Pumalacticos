package Paquete;

import java.util.ArrayList;
import java.util.List;

import Herramienta.Herramienta;

public class Paquete {
    List<Herramienta> herramientas;

    public Paquete(){
        this.herramientas = new ArrayList<>();
    }

    public Paquete(List<Herramienta> herramientas){
        this.herramientas = new ArrayList<>();
        this.herramientas.addAll(herramientas);
    }

}
