package ninjaAcademyApp.Paquete.PaqueteFactory;

import ninjaAcademyApp.Paquete.Paquete;

public class PaqueteDirector {
    private PaqueteBuilder builder;

    public PaqueteDirector(PaqueteBuilder builder){
        this.builder = builder;
    }

 public void construirPaqueteBasico(){
        this.builder.agregarKunai(1);
        this.builder.agregarShuriken(1);
        this.builder.agregarBombaHumo(0);
        this.builder.agregarPapelBomba(0);
        this.builder.agregarBotiquin(1);
    }

    public void construirPaqueteAvanzado(){
        this.builder.agregarKunai(0);
        this.builder.agregarShuriken(2);
        this.builder.agregarBombaHumo(2);
        this.builder.agregarPapelBomba(3);
        this.builder.agregarBotiquin(2);
    }
    
    public void construirPaqueteTactico(){
        this.builder.agregarKunai(3);
        this.builder.agregarShuriken(2);
        this.builder.agregarBombaHumo(2);
        this.builder.agregarPapelBomba(4);
        this.builder.agregarBotiquin(0);
    }

    public Paquete getPaquete(){
        return this.builder.build();
    }
}