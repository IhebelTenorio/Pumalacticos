package pizzabot.helados;

public class ConFresa extends HeladoExtra {

    public ConFresa(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return this.Extra.getDescripcion() + ", con fresas";
    }
    public int getPrecio() {
        return this.Extra.getPrecio() + 5;
    }
}