package pizzabot.helados;

public class ConPanditas extends HeladoExtra {

    public ConPanditas(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return this.Extra.getDescripcion() + ", con panditas";
    }
    public int getPrecio() {
        return this.Extra.getPrecio() + 5;
    }
}
