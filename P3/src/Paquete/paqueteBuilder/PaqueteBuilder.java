package Paquete.paqueteBuilder;

import java.util.ArrayList;
import java.util.List;

import Herramienta.*;
import Paquete.Paquete;


public class PaqueteBuilder implements PBuilder{
    List<Herramienta> herramientas;
    String nombrePaquete = "NA";

    public PaqueteBuilder(){
        herramientas = new ArrayList<>();
    }

    public void reset(){
        herramientas = new ArrayList<>();
        nombrePaquete = "NA";
    }
    public void agregarKunai(int cantidad){
        herramientas.add(new Kunai(cantidad));
    }
    public void agregarShuriken(int cantidad){
        herramientas.add(new Shuriken(cantidad));
    }
    public void agregarBotiquin(int cantidad){
        herramientas.add(new Botiquin(cantidad));
    }
    public void agregarPapelBomba(int cantidad){
        herramientas.add(new PapelBomba(cantidad));
    }
    public void agregarBombaHumo(int cantidad){
        herramientas.add(new BombaHumo(cantidad));
    }

    public void nombrarPaquete(String nombre){
        nombrePaquete = nombre;
    }

    public Paquete getResult(){
        return new Paquete(herramientas, nombrePaquete);
    }
}
