package ninja.registro;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import ninja.*;

public class Registro {
    private Hashtable<String, Aspirante> aspirantes = new Hashtable<>();
    private List<Voluntario> voluntarios = new ArrayList<>();

    public Registro(){
        // No necesitamos nada
    }

    public void registrarAspirante(Aspirante aspirante){
        aspirantes.put(aspirante.getNombre(),aspirante);
    }

    public void registrarVoluntario(Voluntario voluntario){
        voluntarios.add(voluntario);
    }
    
    public Aspirante getAspirante(String nombre){
        return aspirantes.get(nombre);
    }

    public Voluntario getVoluntario(int index){
        return voluntarios.get(index);
    }

    public NinjaIterator getIteradorAspirantes(){
        return new NinjaIterator(new ArrayList<>(aspirantes.values()));
    }

    public NinjaIterator getIteradorVoluntarios(){
        return new NinjaIterator(voluntarios);
    }

    public void retirarAspirante(String nombre){
        aspirantes.remove(nombre);
    }

    public void retirarVoluntario(int index){
        voluntario.
    }



}
