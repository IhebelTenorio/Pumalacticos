package pizzabot.helados;

/**Clase abstracta que es la clase base para los decoradores de la clase Helado
 * 
 */
public abstract class HeladoExtra implements Helado{

    Helado Extra;

    /**
     * Crea una nueva instancia de decoracion de toppings
     * @param Extra el helado, ya sea base o previamente decorado que se le añadira un nuevo extra
     */
    public HeladoExtra(Helado Extra){
        this.Extra = Extra;
    }

    /**
     * Da la descripción del helado con el extra añadido
     * @return la descripción del helado con el nuevo extra
     */
    @Override
    public abstract String getDescripcion(); 
    
    /**
     * Da el precio helado con el extra añadido
     * @return el precio modificado del helado 
     */
    @Override
    public abstract int getPrecio(); 
}

