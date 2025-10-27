package PUMABANK.iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class IteradorPortafolio implements IteradorCuentas{

    private List<Cuenta> cuentasLista;
    private int posicion;

    public IteradorPortafolio(Collection<Cuenta> cuentas){
        this.cuentasLista = new ArrayList<>(cuentas);
        this.posicion = 0;
    }

    @Override
    public Cuenta getNext(){
        if(hasMore()){
            Cuenta cuenta = cuentasLista.get(posicion);
            posicion++;
            return cuenta;
        }
        return null;

    }

    @Override
    public boolean hasMore(){
        return posicion < cuentasLista.size();
    }

    @Override
    public void reiniciar(){
        this.posicion = 0;
    }
    
}
