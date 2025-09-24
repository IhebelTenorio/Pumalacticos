import java.util.ArrayList;
import java.util.List;

import grupo.Grupo;
import ninja.Aspirante;
import ninja.Voluntario;
import ninja.registro.NinjaIterator;
import ninja.registro.Registro;

public class AcademiaNinjaApp{
    private static Registro registro = new Registro();
    public static void main(String[] args) throws Exception{
        // 10 ASPIRANTES (niveles 1-3, diversos clanes)
        registro.registrarAspirante(new Aspirante("Danjiro", 22, "Fuchiha", 2));
        registro.registrarAspirante(new Aspirante("Ihebel", 23, "Osomaki", 3));
        registro.registrarAspirante(new Aspirante("Javier", 26, "Fuchiha", 3));
        registro.registrarAspirante(new Aspirante("Dana", 22, "Mortalika", 2));
        registro.registrarAspirante(new Aspirante("Betsi", 19, "Naca", 2));
        registro.registrarAspirante(new Aspirante("Luis", 19, "Akipichi", 3));
        registro.registrarAspirante(new Aspirante("Lucia", 19, "Mortalika", 1));
        registro.registrarAspirante(new Aspirante("Kiyomi", 19, "Naca", 3));
        registro.registrarAspirante(new Aspirante("Axel", 19, "Akipichi", 2));
        registro.registrarAspirante(new Aspirante("Oscar", 23, "Akipichi", 3));

        // 5 VOLUNTARIOS (niveles 4-6, diversos rangos)
        registro.registrarVoluntario(new Voluntario("Veronica", 34, "Fuchiha", 6, "Jonin")); // 3
        registro.registrarVoluntario(new Voluntario("Canek", 56, "Fuchiha", 4, "Genin")); // 1
        registro.registrarVoluntario(new Voluntario("Victor", 34, "Mortalika", 6, "Jonin")); // 3
        registro.registrarVoluntario(new Voluntario("Rosa", 34, "Akipichi", 5, "Chunin")); // 2
        registro.registrarVoluntario(new Voluntario("Jose Luis",42, "Naca", 6, "Jonin")); // 3

        NinjaIterator volIt = registro.getIteradorVoluntarios();
        NinjaIterator aspIt = registro.getIteradorAspirantes();

        List<Aspirante> posiblesAspirantes = new ArrayList<>();
        Voluntario lider;
        Aspirante aspirante;
        Grupo grupo;

        // Comenzamos con la asignación de grupos
        while(volIt.hasNext()){
            if(!aspIt.hasNext()){ // si no hay más aspirantes de una matamos la asignación
                System.out.print("No hay más aspirantes que asignar");
                break;
            }
            lider = (Voluntario) volIt.next();
            int max = 0;
            if("Genin".equals(lider.getRango())){
                max = 1;
            } else if("Chunin".equals(lider.getRango())){
                max = 2;
            } else if("Jonin".equals(lider.getRango())){
                max = 3;
            } 
            for(int j = 0; j< max; j++){
                if(aspIt.hasNext()){
                    aspirante = (Aspirante) aspIt.next();
                    posiblesAspirantes.add(aspirante);
                }
            }
            // Si llegamos aquí, podemos formar el Grupo.
            grupo = new Grupo(lider, posiblesAspirantes);
            // Llegando aquí, ya se llenaron los datos faltantes del grupo, entonces solo queda imprimir
            grupo.printDescripcion();
            // Se repite el ciclo hasta que no quedan o aspirantes o voluntarios
            posiblesAspirantes.clear();
        }
    }
}