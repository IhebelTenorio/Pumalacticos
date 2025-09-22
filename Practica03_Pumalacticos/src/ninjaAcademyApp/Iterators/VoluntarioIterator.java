package ninjaAcademyApp.Iterators;

import java.util.Hashtable;
import java.util.Iterator;
import ninjaAcademyApp.Ninja.Voluntario;

public class VoluntarioIterator implements Iterator<Voluntario> {
    private Voluntario[] voluntarios;
    private int posicion = 0;

    public VoluntarioIterator(Voluntario[] voluntarios) {
        this.voluntarios = voluntarios;
    }
    
    public boolean hasNext() {
        return posicion < voluntarios.length && voluntarios[posicion] != null;
    }
    
    public Object next() {
        Voluntario voluntario = voluntarios[posicion];
        posicion++;
        return voluntario;
    }
}