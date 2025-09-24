package grupo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import Herramienta.Herramienta;
import Paquete.Paquete;
import Paquete.paqueteBuilder.Director;
import Paquete.paqueteBuilder.PaqueteBuilder;
import campo.*;
import ninja.Aspirante;
import ninja.Voluntario;

public class Grupo {
    private Voluntario lider;
    private List<Aspirante> aspirantes;
    private Paquete paquete;
    private Campo campo;
    private static Scanner sc = new Scanner(System.in);

    public Grupo(Voluntario voluntario, Collection<Aspirante> aspirantes) throws Exception{
        this.lider = voluntario;
        this.aspirantes = new ArrayList<>();
        this.aspirantes.addAll(aspirantes);
        this.paquete = crearPaquete();
        this.campo = crearCampo();
    }

    
    public Paquete crearPaquete() throws Exception{
        Director d = new Director(new PaqueteBuilder());
        int opt = 0;
            System.out.println("Elije un paquete");
            System.out.println("1. Básico");
            System.out.println("2. Avanzado");
            System.out.println("3. Táctico");
            System.out.println("4. Custom");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    return d.construirBasico();
                case 2:
                    return d.construirAvanzado();
                case 3:
                    return d.construirTactico();
                case 4:
                    return d.construirCustom();
                default:
                    throw new Exception("Valor inválido");
            }
    }

    public Campo crearCampo(){
        int nivelTotal = 0;
        for (Aspirante aspirante : aspirantes) {
            nivelTotal = nivelTotal + aspirante.getNivel();
        }
        if(nivelTotal <= 7){
            return new ValleDragon();
        } else if(nivelTotal <= 11){
            return new BosqueSombrio();
        } else {
            return new MontanaEspiritual();
        }
    }




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
        System.out.println("Paquete de herramientas:");
        for (Herramienta herramienta : paquete.getHerramientas()) {
            System.out.println("    "+herramienta.getCantidad()+" - "+herramienta.getNombre());
        }
        System.out.println("Peso Total: " + paquete.getPesoTotal());
        System.out.println("");
        System.out.println("Campo de entrenamiento asignado: " + campo.getNombre());
        System.out.println(campo.getDesc());
        System.out.println("===================================");
        
    }
    
}
