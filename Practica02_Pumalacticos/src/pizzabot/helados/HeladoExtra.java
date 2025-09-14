package pizzabot.helados;
/**
 * La clase abstracta que es la clase base para todos los decoradores que implementa Helado 
 */
public abstract class HeladoExtra implements Helado {

    protected Helado Extra; 

    /**
     * Crea un nuevo ingrediente extra que se va a usar para el helado 
     * @param helado el helado base o ya con ingrediente extra el cual se le va a añadir un nuevo extra
     */
    public HeladoExtra(Helado helado){
        this.Extra = helado;
    }

    /**
     * Da la descripción del helado con el extra aplicado
     * @return la descripción del helado con el extra
     */
    @Override
    public abstract String getDescripcion();

    /**
     * Da el precio del helado con el extra ya puesto
     * @return el precio nuevo del helado 
     */
    @Override
    public abstract int getPrecio();
}
