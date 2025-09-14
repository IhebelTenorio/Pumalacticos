package pizzabot.pizza;

public class PizzaPeperonni extends Pizza {

    public PizzaPeperonni(String tipoMasa) {
        this.masa = tipoMasa;
        this.nombre = "Pizza de Pepperoni";
    }

    protected void agregarQueso() {
        System.out.println("3. Añadiendo queso Mozzarella.");
    }

    protected void agregarProteina() {
        System.out.println("4. Añadiendo generosas rodajas de Pepperoni.");
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return 120;
    }
}