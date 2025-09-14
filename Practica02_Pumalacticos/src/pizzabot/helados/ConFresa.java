package pizzabot.helados;

/**
 * La clase es un decorador de la interfaz Helado
 */
public class ConFresa extends HeladoExtra {

    /**
     * Crea un nuevo decorador que tendra fresas
     * @param helado el helado ya sea base o decorado que se le va a añadir el nuevo extra
     */
    public ConFresa(Helado helado) {
        super(helado);
    }

    /**
     * Da la descripción del helado con el nuevo extra
     * @return descripción extendida del helado con fresas
     */
    @Override
    public String getDescripcion() {
        return Extra.getDescripcion() + ", con fresas";
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