package pizzabot.pizza;

public class PizzaCuatroQuesos extends Pizza {

    public PizzaCuatroQuesos(String tipoMasa) {
        this.masa = tipoMasa;
        this.nombre = "Pizza Cuatro Quesos";
    }

    protected void agregarQueso() {
        System.out.println("3. Añadiendo una base de queso Mozzarella y Manchego.");
    }

    protected void agregarProteina() {
        // En esta pizza, el "ingrediente principal" es más queso.
        System.out.println("4. Añadiendo toques de queso Parmesano y queso doble crema.");
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return 145;
    }
}