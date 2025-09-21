package ninjaAcademyApp.Paquete.PaqueteFactory;

import ninjaAcademyApp.Paquete.Paquete;

public class PaqueteDirector {
    private PaqueteBuilder builder;

    public PaqueteDirector(PaqueteBuilder builder){
        this.builder = builder;
    }

    public Paquete construirPaquete(){
        builder.agregarKunai();
        builder.agregarBotiquin();
        builder.agregarShuriken();
        builder.agregarPapelBomba();
        builder.agregarBombaHumo();
        return builder.build();
    }
}
