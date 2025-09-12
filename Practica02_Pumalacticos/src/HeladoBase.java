public class HeladoBase implements Helado {
    int precio;
    String sabor;

    public HeladoBase(int precio, String sabor){
        precio = this.precio;
        sabor = this.sabor;

    }

    public String getNombre(){
        return "Hola";
    }

    public int getPrecio(){
        return precio;
    }
}
