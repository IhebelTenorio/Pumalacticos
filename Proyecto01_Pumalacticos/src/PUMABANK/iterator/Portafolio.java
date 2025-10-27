package PUMABANK.iterator;

import java.util.List;

public interface Portafolio {
    public IteradorCuentas crearIterador();

    public void agregarCuenta(Cuenta cuenta);
}
