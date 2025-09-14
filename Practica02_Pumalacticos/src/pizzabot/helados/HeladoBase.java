package pizzabot.helados;

/**
 * Clase que representa un helado simple, que no tiene ningun extra, implementa la interfaz Helado
 */
public class HeladoBase implements Helado {
    int precio;
    String sabor;

    /**
     * Crea un nuevo helado con un sabor y precio definido
     * @param precio precio del helado base
     * @param sabor sabor del helado 
     */
    public HeladoBase(int precio, String sabor){
        precio = this.precio;
        sabor = this.sabor;

    }

    /**
     * Da la descripción de un helado
     * @return una cadena con el sabor del helado 
     */
    @Override
    public String getDescripcion(){
        return "Sabor del Helado: " + sabor;
    }

    /**
     * Da el precio de un helado
     * @return el precio del helado
     */
    @Override
    public int getPrecio(){
        return precio;
    }
}
