package pizzabot.helados;
/**
 * Es una interfaz que define la estructura básica que debe tener todos los helados del sistema 
 */
public interface Helado  {
    
    /**
     * Da la descripción de un helado
     * @return los detalles del helado con el nombre
     */
    public String getDescripcion();

    /**
     * Da el precio final del helado 
     * @return el precio del helado
     */
    public int getPrecio();

    
}