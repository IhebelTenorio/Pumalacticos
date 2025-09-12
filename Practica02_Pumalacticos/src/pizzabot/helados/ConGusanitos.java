package pizzabot.helados;

public class ConGusanitos extends HeladoExtra {

    public ConGusanitos(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return Extra.getDescripcion() + ", con gusanitos";
    }
    public int getPrecio() {
        return Extra.getPrecio() + 5;
    }
}