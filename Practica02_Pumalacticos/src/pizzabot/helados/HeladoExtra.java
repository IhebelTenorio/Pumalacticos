package pizzabot.helados;
public abstract class HeladoExtra implements Helado{

    Helado Extra;

    public HeladoExtra(Helado Extra){
        this.Extra = Extra;
    }

    public abstract String getDescripcion(); {}

    public abstract int getPrecio(); {}
}

