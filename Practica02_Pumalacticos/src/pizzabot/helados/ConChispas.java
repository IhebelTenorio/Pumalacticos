package pizzabot.helados;

public class ConChispas extends HeladoExtra {

    public ConChispas(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return this.Extra.getDescripcion() + ", con chispas de chocolate";
    }
    public int getPrecio() {
        return this.Extra.getPrecio() + 5;
    }
}
