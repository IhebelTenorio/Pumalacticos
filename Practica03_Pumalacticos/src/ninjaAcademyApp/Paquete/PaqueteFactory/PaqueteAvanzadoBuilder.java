package ninjaAcademyApp.Paquete.PaqueteFactory;

import java.util.ArrayList;
import java.util.List;
import ninjaAcademyApp.Herramienta.Herramienta;
import ninjaAcademyApp.Herramienta.BombaHumo;
import ninjaAcademyApp.Herramienta.Botiquin;
import ninjaAcademyApp.Herramienta.PapelBomba;
import ninjaAcademyApp.Herramienta.Shuriken;
import ninjaAcademyApp.Paquete.Paquete;

public class PaqueteAvanzadoBuilder implements PaqueteBuilder{
    private List<Herramienta> herramientas = new ArrayList<>();
    
    public PaqueteAvanzadoBuilder(){}

    public void agregarKunai(){
    }
    public void agregarShuriken(){
        herramientas.add(new Shuriken(2));
    }
    public void agregarBotiquin(){
        herramientas.add(new Botiquin(2));
    }
    public void agregarPapelBomba(){
        herramientas.add(new PapelBomba(3));
    }
    public void agregarBombaHumo(){
        herramientas.add(new BombaHumo(2));
    }

    public Paquete build(){
        return new Paquete(herramientas);
    }

}
