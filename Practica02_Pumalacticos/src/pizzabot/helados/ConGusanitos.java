package pizzabot.helados;

public class ConGusanitos extends HeladoExtra {

    public ConGusanitos(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return this.Extra.getDescripcion() + ", con gusanitos";
    }
    public int getPrecio() {
        return this.Extra.getPrecio() + 5;
    }
}