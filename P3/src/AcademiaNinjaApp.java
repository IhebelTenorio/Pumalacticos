import java.util.ArrayList;
import java.util.List;

import grupo.Grupo;
import ninja.Aspirante;
import ninja.Ninja;
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

        for (Ninja ninja : registro.getAspirantes()) {
            System.out.println(ninja.getNombre());
        }

        //Grupo grupo = new Grupo();
        List<Aspirante> posiblesAspirantes = new ArrayList<>();
        Voluntario lider;
        Aspirante aspirante;
        Grupo grupo;
        while(true){
            if(volIt.hasNext()){ //checamos si hay voluntarios
                // Si si los hay empezamos a llenar una lista de aspirantes (o tratamos)
                lider = (Voluntario) volIt.next();
                //System.out.println(lider.getNombre());
                if(lider.getRango() == "Genin"){ // 1 aspirante
                    // Intentamos meter aspirantes
                    for(int i = 0; i < 1; i++){
                        if(aspIt.hasNext()){
                            aspirante = (Aspirante) aspIt.next();
                            posiblesAspirantes.add(aspirante);
                        }
                    }

                } else if(lider.getRango() == "Chunin"){ // 2 aspirantes
                    // Intentamos meter aspirantes
                    for(int i = 0; i < 2; i++){
                        if(aspIt.hasNext()){
                            aspirante = (Aspirante) aspIt.next();
                            posiblesAspirantes.add(aspirante);
                        }
                    }

                } else if(lider.getRango() == "Jonin"){ // 3 aspirantes
                    // Intentamos meter aspirantes
                    for(int i = 0; i < 3; i++){
                        if(aspIt.hasNext()){
                            aspirante = (Aspirante) aspIt.next();
                            posiblesAspirantes.add(aspirante);
                        }
                    }

                } else {
                    throw new Exception("Rango del lider no definido en el main");
                }

            } else { // no hay hasNext() en el iterador de voluntarios.
                System.out.println("No quedan voluntarios para liderar los grupos");
                System.out.println("Lamentamos la situación a los aspirantes: ");
                while(aspIt.hasNext()){
                    aspirante = (Aspirante) aspIt.next();
                    System.out.println(aspirante.getNombre() + " " + aspirante.getClan());
                }
                break;
            }
            if(posiblesAspirantes.size() == 0){ // checamos rapido si el arreglo de aspirantes esta vacío, si si, GG.
                System.out.println("No quedan aspirantes para formar los grupos");
                break;
            }
            // Si llegamos aquí, podemos formar el Grupo.
            grupo = new Grupo(lider, posiblesAspirantes);
            // Llegando aquí, ya se llenaron los datos faltantes del grupo, entonces solo queda imprimir
            grupo.printDescripcion();
            // Se repite el ciclo hasta que no quedan o aspirantes o voluntarios
        }
    }
}