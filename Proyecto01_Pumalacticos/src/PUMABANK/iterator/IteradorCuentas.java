package PUMABANK.iterator;

public interface IteradorCuentas {
    public Cuenta getNext();
    public boolean hasMore();
    public void reiniciar();
}
