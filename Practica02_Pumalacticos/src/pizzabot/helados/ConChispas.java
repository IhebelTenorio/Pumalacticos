package pizzabot.helados;

public class ConChispas extends HeladoExtra {

    public ConChispas(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return Extra.getDescripcion() + ", con chispas de chocolate";
    }
    public int getPrecio() {
        return Extra.getPrecio() + 5;
    }
}
