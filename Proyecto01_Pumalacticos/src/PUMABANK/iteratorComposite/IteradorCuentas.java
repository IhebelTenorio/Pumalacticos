package PUMABANK.iteratorComposite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import PUMABANK.decorator.ICuenta;

public class IteradorCuentas implements Iterator<ICuenta>{

    private ArrayList<ICuenta> cuentas;
    private int size;
    int i = 0;
    
    public IteradorCuentas(Collection<ICuenta> c){
        this.cuentas = new ArrayList<>();
        this.cuentas.addAll(c);
        this.size = c.size();
        
    }


    @Override
    public boolean hasNext() {
        return size > i;
    }


    @Override
    public ICuenta next() {
        ICuenta a = cuentas.get(i);
        i++;
        return a;
    }
}
