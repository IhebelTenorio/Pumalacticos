package pizzabot.helados;

/**
 * La clase es un decorador de la interfaz Helado
 */
public class ConPanditas extends HeladoExtra {

    /**
     * Crea un nuevo decorador que tendra panditas
     * @param helado el helado ya sea base o decorado que se le va a añadir el nuevo extra
     */
    public ConPanditas(Helado helado) {
        super(helado);
    }

    /**
     * Da la descripción del helado con el nuevo extra
     * @return descripción extendida del helado con panditas
     */
    @Override
    public String getDescripcion() {
        return Extra.getDescripcion() + ", con panditas";
    }

    /**
     * Da el precio del helado con el nuevo costo del extra
     * @return precio del helado aumentando 5
     */
    @Override
    public int getPrecio() {
        return Extra.getPrecio() + 5;
    }
}
