package pizzabot.helados;

public class ConManguitos extends HeladoExtra {

    public ConManguitos(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return this.Extra.getDescripcion() + ", con manguitos";
    }
    public int getPrecio() {
        return this.Extra.getPrecio() + 5;
    }
}
