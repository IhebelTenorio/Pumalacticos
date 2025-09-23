package ninjaAcademyApp.Ninja;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Clase que administra a los aspirantes mediante una hashtable y la clave es el nombre de los aspirantes
 */
public class HashTableAspirantes {
    private Hashtable<String, Aspirante> aspirantes;

    /**
     * Crea una nueva instancia de HashTableAspirantes
     */
    public HashTableAspirantes() {
        this.aspirantes = new Hashtable<>();
    }

    /**
     * Agrega un aspirante a la tabla
     * @param aspirante aspirante que se va a agregar
     */
    public void agregarAspirante(Aspirante aspirante) {
        aspirantes.put(aspirante.getNombre(), aspirante);
    }

    /**
     * Crea un iterador para recorrer todos los aspirantes en la tabla
     * @return iterador de Aspirante
     */
    public Iterator<Aspirante> crearIterador() {
        return new AspiranteIterator(aspirantes);
    }
}