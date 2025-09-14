package pizzabot.helados;

public abstract class HeladoExtra implements Helado {

    protected Helado Extra; 

    public HeladoExtra(Helado helado){
        this.Extra = helado;
    }

    public abstract String getDescripcion();
    public abstract int getPrecio();
}
