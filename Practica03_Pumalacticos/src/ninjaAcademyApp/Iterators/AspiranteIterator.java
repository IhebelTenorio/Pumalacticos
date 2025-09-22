package ninjaAcademyApp.Iterators;

import java.util.Hashtable;
import java.util.Iterator;
import ninjaAcademyApp.Ninja.Aspirante;


public class AspiranteIterator implements Iterator<Aspirante> {

    private Iterator<Aspirante> iterator;

    public AspiranteIterator(Hashtable<String, Aspirante> aspirantes) {
        this.iterator = aspirantes.values().iterator();
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public Aspirante next() {
        return this.iterator.next();
    }
}