package PUMABANK.iterator;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class PortafolioUnificado implements Portafolio{

    private Map<String, Cuenta> cuentas;

    public PortafolioUnificado(){
        this.cuentas = new HashMap<>();
    }

    @Override
    public void agregarCuenta(Cuenta cuenta){
        this.cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

    @Override
    public IteradorCuentas crearIterador(){
        return new IteradorPortafolio(this.cuentas.values());
    }

    public double calcularSaldo(){
        IteradorCuentas it = crearIterador();
        double saldoTotal = 0.0;

        System.out.println("\n-----Calculando saldo total--------");
        while (it.hasMore()){
            Cuenta cuenta  = it.getNext();
            saldoTotal += cuenta.getFondo();
            System.out.println(" > " + cuenta.getTipoCuenta() + cuenta.getNumeroCuenta() + ": $" + cuenta.getFondo());
            
        }

        return saldoTotal;
    }

    
    
}
