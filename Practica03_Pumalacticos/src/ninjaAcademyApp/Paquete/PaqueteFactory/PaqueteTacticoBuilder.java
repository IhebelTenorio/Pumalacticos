package ninjaAcademyApp.Paquete.PaqueteFactory;

import java.util.ArrayList;
import java.util.List;
import ninjaAcademyApp.Herramienta.Herramienta;
import ninjaAcademyApp.Herramienta.Botiquin;
import ninjaAcademyApp.Herramienta.Kunai;
import ninjaAcademyApp.Herramienta.Shuriken;
import ninjaAcademyApp.Paquete.Paquete;

public class PaqueteTacticoBuilder implements PaqueteBuilder{
    private List<Herramienta> herramientas = new ArrayList<>();
    
    public PaqueteTacticoBuilder(){}

    public void agregarKunai(){
        herramientas.add(new Kunai(1));
    }
    public void agregarShuriken(){
        herramientas.add(new Shuriken(1));
    }
    public void agregarBotiquin(){
        herramientas.add(new Botiquin(1));
    }
    public void agregarPapelBomba(){}
    public void agregarBombaHumo(){}

    public Paquete build(){
        return new Paquete(herramientas);
    }

}
