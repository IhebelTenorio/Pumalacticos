package grupo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Paquete.Paquete;
import ninja.Aspirante;
import ninja.Voluntario;

public class Grupo {
    private Voluntario lider;
    private List<Aspirante> aspirantes;
    private Paquete paquete;
    //private Campo campo;
    public Grupo(Voluntario voluntario, Collection<Aspirante> aspirantes){
        this.lider = voluntario;
        this.aspirantes = new ArrayList<>();
        this.aspirantes.addAll(aspirantes);
    }

    public void setPaquete(String tipo){}

    public void printDescripcion(){
        System.out.println("====== REGISTRO = DE = GRUPO ======");
        System.out.println("Lider:" );
        System.out.println("    Nombre:" + lider.getNombre() + " " + lider.getClan());
        System.out.println("    Edad:" + lider.getEdad());
        System.out.println("    Rango: " + lider.getRango());
        System.out.println("    Nivel: " + lider.getNivel());
        System.out.println("Aspirantes: ");
        System.out.println("");
        for (Aspirante aspirante : aspirantes) {
            System.out.println("    " + aspirante.getNombre() + " " + aspirante.getClan());
            System.out.println("        Edad:" + aspirante.getEdad());
            System.out.println("        Nivel: " + aspirante.getNivel());
            //System.out.println("- - - - - - - - - - - - - - - - - -");
        }
        System.out.println("Equipo:");
        System.out.println("");
        System.out.println("");
        System.out.println("Campo de entrenamiento asignado:");
        System.out.println("");
        System.out.println("===================================");
        
    }
    
}
