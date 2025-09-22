package ninjaAcademyApp.Ninja;

import java.util.Hashtable;
import java.util.Iterator;

public class HashTableAspirantes {
    private Hashtable<String, Aspirante> aspirantes;

    public HashTableAspirantes() {
        this.aspirantes = new Hashtable<>();
    }

    public void agregarAspirante(Aspirante aspirante) {
        aspirantes.put(aspirante.getNombre(), aspirante);
    }

    public Iterator<Aspirante> crearIterador() {
        return new AspiranteIterator(aspirantes);
    }
}