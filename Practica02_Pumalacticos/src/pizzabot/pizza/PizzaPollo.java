package pizzabot.pizza;

public class PizzaPollo extends Pizza {

    public PizzaPollo(String tipoMasa) {
        this.masa = tipoMasa;
        this.nombre = "Pizza de Pollo";
    }

    protected void agregarQueso() {
        System.out.println("3. Añadiendo una mezcla de queso Gouda y Mozzarella.");
    }

    protected void agregarProteina() {
        System.out.println("4. Añadiendo trozos de pollo y cebolla morada.");
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return 150;
    }
}