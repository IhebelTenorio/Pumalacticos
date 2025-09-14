package pizzabot.pizza;

public class PizzaVegetariana extends Pizza {

    public PizzaVegetariana(String tipoMasa) {
        this.masa = tipoMasa;
        this.nombre = "Pizza Vegetariana";
    }

    protected void agregarQueso() {
        System.out.println("3. Añadiendo queso Panela.");
    }

    protected void agregarProteina() {
        // Para la pizza vegetariana, el ingrediente principal son los vegetales.
        System.out.println("4. Añadiendo champiñones, pimiento verde, aceitunas y elote.");
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return 200;
    }
}