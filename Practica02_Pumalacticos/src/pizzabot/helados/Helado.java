package pizzabot.helados;
//Define los métodos que deben implementar tanto los helados base como los extras.
/**
 * Interfaz que define la estructura que debe seguir todos los helados del programa
 */
public interface Helado  {

    /**
     * Da la descripción de un helado
     */
    public String getDescripcion();

    /**
     * Da el precio de un helado
     */
    public int getPrecio();

    
}