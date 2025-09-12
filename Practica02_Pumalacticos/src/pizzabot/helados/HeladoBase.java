package pizzabot.helados;
public class HeladoBase implements Helado {
    int precio;
    String sabor;

    public HeladoBase(int precio, String sabor){
        precio = this.precio;
        sabor = this.sabor;

    }

    public String getNombre(){
        return "El sabor del helado es" + sabor;
    }
    public String getDescripcion(){
        return "Sabor del Helado: " + sabor;
    }

    public int getPrecio(){
        return precio;
    }
}
