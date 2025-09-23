package ninjaAcademyApp.Grupo;

import java.util.ArrayList;
import java.util.List;
import ninjaAcademyApp.Ninja.*;
import ninjaAcademyApp.Paquete.Paquete;
import ninjaAcademyApp.Paquete.PaqueteFactory.PaqueteBuilder;
import ninjaAcademyApp.Paquete.PaqueteFactory.PaqueteBuilderFactory;
import ninjaAcademyApp.Paquete.PaqueteFactory.PaqueteDirector;

/**
 * Clase que representa a un grupo de aspirantes a ninjas liderados por un voluntario
 */
public class Grupo {
    private Voluntario lider;
    private List<Ninja> aspirantes;
    private Paquete paquete;
    //private LugarEntrenamiento lugar;

    /**
     * Crea una instancia de Grupo con un lider y una lista de aspirantes
     * @param lider voluntario que liderara al grupo
     * @param aspirantes lista de aspirantes a ser ninjas
     */
    public Grupo(Voluntario lider, List<Ninja> aspirantes){
        this.lider = lider;
        this.aspirantes = new ArrayList<>();
        this.aspirantes.addAll(aspirantes);
    }

    /**
     * Asigna un paquete al grupo según el tipo dado
     * @param tipo tipo de paquete a asignar
     */
    public void setPaquete(String tipo){ // Tier Basico, avanzado, tactico, custom
        PaqueteBuilder builder = PaqueteBuilderFactory.crearBuilder(tipo); 
        PaqueteDirector director = new PaqueteDirector(builder);
        this.paquete = director.construirPaquete();
    }
}
