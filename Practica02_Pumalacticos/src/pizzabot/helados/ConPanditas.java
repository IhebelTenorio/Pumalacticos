package pizzabot.helados;

public class ConPanditas extends HeladoExtra {

    public ConPanditas(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return Extra.getDescripcion() + ", con panditas";
    }
    public int getPrecio() {
        return Extra.getPrecio() + 5;
    }
}
