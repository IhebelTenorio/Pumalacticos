package pizzabot.helados;

/**
 * Clase que es un decorador de la clase HeladoExtra 
 */
public class ConChispas extends HeladoExtra {

    /**
     * Crea un nuevo decorador 
     * @param helado el helado base o decorado el cual se le pondra las chispas
     */
    public ConChispas(Helado helado) {
        super(helado);
    }

    /**
     * Da la descripción del helado y da el extra que se agrego
     * @return la descripción del helado con las chispas
     */
    @Override
    public String getDescripcion() {
        return this.Extra.getDescripcion() + ", con chispas de chocolate";
    }
    
    /**
     * Da el precio del helado agregando el costo del extra
     * @return precio del helado con 5 mas 
     */
    @Override
    public int getPrecio() {
        return this.Extra.getPrecio() + 5;
    }
}
