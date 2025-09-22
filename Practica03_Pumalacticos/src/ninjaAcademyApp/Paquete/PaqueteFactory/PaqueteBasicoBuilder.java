package ninjaAcademyApp.Paquete.PaqueteFactory;

import java.util.ArrayList;
import java.util.List;
import ninjaAcademyApp.Herramienta.*;
import ninjaAcademyApp.Paquete.Paquete;

public class PaqueteBasicoBuilder implements PaqueteBuilder{
    private Paquete paquete;
    
    public PaqueteBasicoBuilder();{
        this.paquete = new Paquete();
}

    public void agregarKunai(int cantidad){
        for(int i=0; i < cantidad; i++){
            this.paquete.agregarHerramienta(new Kunai());
        }
    }
    public void agregarShuriken(int cantidad){
        for(int i=0; i < cantidad; i++){
            this.paquete.agregarHerramienta(new Shuriken());
        }
    }
    public void agregarBotiquin(int cantidad){
        for(int i=0; i < cantidad; i++){
            this.paquete.agregarHerramienta(new Botiquin());
        }
    }
    public void agregarPapelBomba(int cantidad){}
    public void agregarBombaHumo(int cantidad){}

    public Paquete build(){
        return this.paquete;
    }

}
