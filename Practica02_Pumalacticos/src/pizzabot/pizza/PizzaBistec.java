package pizzabot.pizza;

public class PizzaBistec extends Pizza {

    public PizzaBistec(String tipoMasa) {
        this.masa = tipoMasa;
        this.nombre = "Pizza de Bistec";
    }

    protected void agregarQueso() {
        System.out.println("3. Añadiendo queso Oaxaca derretido.");
    }

    protected void agregarProteina() {
        System.out.println("4. Añadiendo trozos de bistec asado, cebolla y cilantro.");
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return 180;
    }
}