package pizzabot.pizza;

public abstract class Pizza {

    protected String masa;
    protected String nombre;

    public final void preparar() throws InterruptedException {
        System.out.println("Iniciando preparación de: " + this.nombre + " ");
        prepararMasa();
        Thread.sleep(500);
        aplanarMasa();
        Thread.sleep(500);
        colocarSalsaDeTomate();
        Thread.sleep(500);
        agregarQueso(); // varia
        Thread.sleep(500);
        colocarEspecias();
        Thread.sleep(500);
        agregarProteina(); // varia
        Thread.sleep(500);
        hornear();
        Thread.sleep(3000);
        esperar();
        Thread.sleep(2500);
        sacarDelHorno();
        Thread.sleep(1000);
        empaquetar();
        Thread.sleep(1000);
        System.out.println(" ¡" + this.nombre + " lista para entregar! :) ");

    }

    private void prepararMasa() {
        System.out.println("1. Preparando masa " + this.masa);
    }

    private void aplanarMasa() {
        System.out.println("2. Aplanando masa ");
    }

    private void colocarSalsaDeTomate() {
        System.out.println("3. Añadiendo salsa de tomate ");
    }

    private void colocarEspecias() {
        System.out.println("5. Añadiendo especias de la formula secreta... ");
    }
    private void hornear() {
        System.out.println("6. Horneando la pizza, no acercarse ");
    }

    private void esperar() {
        System.out.println("7. Cocinandooooooo... ");
    }

    private void sacarDelHorno() {
        System.out.println("8. Sacando del horno... ");
    }

    private void empaquetar() {
        System.out.println("9. Empaquetando....! Ya casi ");
    }

    protected abstract void agregarQueso();

    protected abstract void agregarProteina();

    public abstract String getNombre();

    public abstract int getPrecio();
    
    public String getMasa() {
        return masa;
    }
}