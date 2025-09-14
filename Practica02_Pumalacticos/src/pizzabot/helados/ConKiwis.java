package pizzabot.helados;

public class ConKiwis extends HeladoExtra {

    public ConKiwis(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return this.Extra.getDescripcion() + ", con kiwis";
    }
    public int getPrecio() {
        return this.Extra.getPrecio() + 5;
    }
}
