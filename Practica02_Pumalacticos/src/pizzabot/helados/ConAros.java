package pizzabot.helados;

public class ConAros extends HeladoExtra {

    public ConAros(Helado helado) {
        super(helado);
    }
   // @Override
    public String getDescripcion() {
        return Extra.getDescripcion() + ", con aros";
    }
    public int getPrecio() {
        return Extra.getPrecio() + 5;
    }
}
