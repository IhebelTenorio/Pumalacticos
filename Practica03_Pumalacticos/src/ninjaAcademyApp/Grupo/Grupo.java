package ninjaAcademyApp.Grupo;

import java.util.ArrayList;
import java.util.List;
import ninjaAcademyApp.Ninja.*;
import ninjaAcademyApp.Paquete.Paquete;
import ninjaAcademyApp.Paquete.PaqueteFactory.PaqueteBuilder;
import ninjaAcademyApp.Paquete.PaqueteFactory.PaqueteBuilderFactory;
import ninjaAcademyApp.Paquete.PaqueteFactory.PaqueteDirector;

public class Grupo {
    private Voluntario lider;
    private List<Ninja> aspirantes;
    private Paquete paquete;
    //private LugarEntrenamiento lugar;

    public Grupo(Voluntario lider, List<Ninja> aspirantes){
        this.lider = lider;
        this.aspirantes = new ArrayList<>();
        this.aspirantes.addAll(aspirantes);
    }

    public void setPaquete(String tipo){ // Tier Basico, avanzado, tactico, custom
        PaqueteBuilder builder = PaqueteBuilderFactory.crearBuilder(tipo); 
        PaqueteDirector director = new PaqueteDirector(builder);
        this.paquete = director.construirPaquete();
    }
}
