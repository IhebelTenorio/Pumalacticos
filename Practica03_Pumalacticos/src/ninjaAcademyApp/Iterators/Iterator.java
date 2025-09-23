package ninjaAcademyApp.Iterators;

/**
 * Iterfaz que define el comportamiento base para recorrer los elementos de una colección 
 */
public interface Iterator {

    /**
     * Checa si hay un eemento por recorrer
     * @return <true> si hay más elementos, <fasle> de lo contrario
     */
    boolean hasNext();

    /**
     * Regresa el siguiente elemento
     * @return el siguiente elemento
     */
    Object next();
}