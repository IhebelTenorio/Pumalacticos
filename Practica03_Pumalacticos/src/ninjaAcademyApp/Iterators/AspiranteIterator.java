package ninjaAcademyApp.Iterators;

import java.util.Hashtable;
import java.util.Iterator;
import ninjaAcademyApp.Ninja.Aspirante;

/**
 * Clase que implementa un Iterador que recorre objetos de tipo Aspirante que estan dentor de una hastable
 */
public class AspiranteIterator implements Iterator<Aspirante> {

    /**
     * Iterador de valores de la tabla hash
     */
    private Iterator<Aspirante> iterator;

    /**
     * Crea un iterador para recorrer a los aspirantes  en la tabla hash
     * @param aspirantes tabla hash de aspirantes 
     */
    public AspiranteIterator(Hashtable<String, Aspirante> aspirantes) {
        this.iterator = aspirantes.values().iterator();
    }

    /**
     * Checa si aun hay más aspirantes por recorrer
     * @return <true> si hay más aspirantes, <false> d elo contrario
     */
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    /**
     * Regresa al siguiente aspirante de la colección
     * @return el siguiente aspirante
     */
    public Aspirante next() {
        return this.iterator.next();
    }
}