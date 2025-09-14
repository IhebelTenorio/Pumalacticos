package pizzabot.pizza;

public class PizzaHawaiana extends Pizza {


//El tipo de masa seleccionado por el cliente.
    public PizzaHawaiana(String tipoMasa) {
        this.masa = tipoMasa;
        this.nombre = "Pizza Hawaiana";
    }

    protected void agregarQueso() {
        System.out.println("3. Añadiendo queso Manchego y mozzarella.");
    }

    protected void agregarProteina() {
        System.out.println("4. Añadiendo trozos de jamón de pavo y piña dulce(iuk).");
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return 130;
    }
}