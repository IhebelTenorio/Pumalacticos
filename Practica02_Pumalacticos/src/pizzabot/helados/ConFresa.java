package pizzabot.helados;

public class ConFresa extends HeladoExtra {

    public ConFresa(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return Extra.getDescripcion() + ", con fresas";
    }
    public int getPrecio() {
        return Extra.getPrecio() + 5;
    }
}