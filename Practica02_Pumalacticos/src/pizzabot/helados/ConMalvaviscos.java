package pizzabot.helados;

public class ConMalvaviscos extends HeladoExtra {

    public ConMalvaviscos(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return this.Extra.getDescripcion() + ", con malvaviscos";
    }
    public int getPrecio() {
        return this.Extra.getPrecio() + 5;
    }
}
