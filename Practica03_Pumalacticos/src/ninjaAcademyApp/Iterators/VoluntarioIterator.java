package ninjaAcademyApp.Iterators;

import java.util.Hashtable;
import java.util.Iterator;
import ninjaAcademyApp.Ninja.Voluntario;

/**
 * Clase que  implementa un Iterador para recorrer un arreglo de objetos de tipo Voluntario
 */
public class VoluntarioIterator implements Iterator<Voluntario> {
    private Voluntario[] voluntarios;
    private int posicion = 0;

    /**
     * Crea un iterador para recorrer un arreglo de voluntarios
     * @param voluntarios arreglo de objetos de tipo Voluntario
     */
    public VoluntarioIterator(Voluntario[] voluntarios) {
        this.voluntarios = voluntarios;
    }
    
    /**
     * Checa si hay más voluntarios por recorrer
     * @return <true> si aun hay elementos, <false> de lo contrario
     */
    public boolean hasNext() {
        return posicion < voluntarios.length && voluntarios[posicion] != null;
    }
    
    /**
     * Regresa el siguiente voluntario
     * @return el siguiente voluntario
     */
    public Object next() {
        Voluntario voluntario = voluntarios[posicion];
        posicion++;
        return voluntario;
    }
}