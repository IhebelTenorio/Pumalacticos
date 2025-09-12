package pizzabot.pizza;

public abstract class PrepararPizza {

    public final void prepararPizza() throws InterruptedException{
        prepararMasa();
        Thread.sleep(500);
        aplanarMasa();
        Thread.sleep(500);
        colocarSalsaDeTomate();
        Thread.sleep(500);
        colocarQueso();
        Thread.sleep(500);
        colocarEspecias();
        Thread.sleep(500);
        colocarProteina();
        Thread.sleep(1000);
        meterAlHorno();
        Thread.sleep(5000);
        esperar();
        Thread.sleep(2500);
        sacarDelHorno();
        Thread.sleep(1000);
        empaquetar();
        Thread.sleep(1000);
    }

    protected abstract void empaquetar() throws InterruptedException;

    protected abstract void sacarDelHorno();

    protected abstract void esperar();

    protected abstract void meterAlHorno();

    protected abstract void colocarProteina();

    protected abstract void colocarEspecias();

    protected abstract void colocarQueso();

    protected abstract void colocarSalsaDeTomate();

    protected abstract void aplanarMasa();

    protected abstract void prepararMasa();

}
