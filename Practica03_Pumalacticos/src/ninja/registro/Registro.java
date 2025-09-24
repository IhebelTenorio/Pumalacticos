package ninja.registro;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import ninja.*;

public class Registro {
    private Hashtable<String, Ninja> aspirantes;
    private List<Ninja> voluntarios;

    public Registro(){
        aspirantes = new Hashtable<>();
        voluntarios = new ArrayList<>();
    }

    public void registrarAspirante(Aspirante aspirante){
        aspirantes.put(aspirante.getNombre(),aspirante);
    }

    public void registrarVoluntario(Voluntario voluntario){
        voluntarios.add(voluntario);
    }
    
    public Ninja getAspirante(String nombre){
        return aspirantes.get(nombre);
    }

    public Ninja getVoluntario(int index){
        return voluntarios.get(index);
    }

    public NinjaIterator getIteradorAspirantes(){
        return new NinjaIterator(new ArrayList<>(aspirantes.values()));
    }

    public NinjaIterator getIteradorVoluntarios(){
        return new NinjaIterator(voluntarios);
    }

}
