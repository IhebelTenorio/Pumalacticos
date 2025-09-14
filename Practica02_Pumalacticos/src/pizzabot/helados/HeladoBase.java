package pizzabot.helados;

/**
 * La clase que representa un helado base, sin extras y que implementa la interfaz de Helado
 */
public class HeladoBase implements Helado {
    int precio;
    String sabor;

    /**
     * Crea un nuevo helado base con un sabor y precio ya definido
     * @param precio precio del helado
     * @param sabor sabor del helado
     */
    public HeladoBase(int precio, String sabor){
        this.precio = precio;
        this.sabor = sabor;

    }

    /**
     * Da la descripción de un helado
     * @return El sabor del helado expresado en un mensaje
     */
    @Override
    public String getDescripcion(){
        return "Sabor del Helado: " + sabor;
    }

    /**
     * De el precio de un helado
     * @return el precio del helado
     */
    @Override
    public int getPrecio(){
        return precio;
    }
}
