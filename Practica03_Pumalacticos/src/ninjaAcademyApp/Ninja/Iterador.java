package ninjaAcademyApp.Ninja;

/**
 * Interfaz que define el como se va a recorrrer las colecciones de elementos 
 */
public interface Iterador<E> {
    
    /**
     * Checa si existen más elementos en la coleccipon
     * @return <true> si hay más elementos, <false> de lo contrario
     */
    public boolean hasNext();

    /**
     * regresa el siguiente elemento de la colección 
     * @return el siguiente elemento 
     */
    public E next();


}
