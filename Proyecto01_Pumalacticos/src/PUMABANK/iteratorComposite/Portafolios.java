package PUMABANK.iteratorComposite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.sound.sampled.Port;

import PUMABANK.decorator.ICuenta;
import PUMABANK.strategy.IEstrategiaInteres;

// Esta clase representa un nodo de composite, cada cuenta es un hijo, entonces se delega el trabajo de cada metodo a los hijos.


public class Portafolios implements Iterable<ICuenta>, ICuenta {
    private ArrayList<ICuenta> cuentas;
    private String numeroDeCuenta;

    public Portafolios(String numeroDeCuenta, Collection<ICuenta> c){
        this.cuentas = new ArrayList<>();
        this.cuentas.addAll(c);
        this.numeroDeCuenta = numeroDeCuenta;
    }

    @Override
    public Iterator iterator() {
        return new IteradorCuentas(cuentas);
    }

    @Override
    public void retirar(double monto) {
        for (ICuenta cuenta : cuentas) {
            cuenta.retirar(monto/cuentas.size());
            
        }
    }

    @Override
    public void depositar(double monto) {
        for (ICuenta cuenta : cuentas) {
            cuenta.depositar(monto/cuentas.size());
        }
    }

    @Override
    public double getSaldo() {
        double saldoTotal = 0;
        for (ICuenta cuenta : cuentas) {
            saldoTotal = saldoTotal + cuenta.getSaldo();
        }
        return saldoTotal;
    }

    @Override
    public void cerrarCuenta() {
        if(cuentas.size()==0){
            System.out.println("Portafolio vacío, se eliminará");
            Portafolios actual = this;
            actual = null; // por alguna razon esto me parece cruel xd
        } else {
            System.out.println("Por seguridad, se deben borrar primero las cuentas");
        }
    }

    @Override
    public void aplicarInteres() {
        // Simplemente no hacemos nada, esto es parte de update()
    }

    @Override
    public void setEstrategiaInteres(IEstrategiaInteres nuevaEstrategia) {
        
    }

    @Override
    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    @Override
    public String getNombreCliente() {
        String nombre = cuentas.get(0).getNombreCliente();
        for(int i=1; i<cuentas.size(); i++){
            if(!(cuentas.get(i).getNombreCliente()).equals(nombre)){
                return "Varios propietarios";
            }
        }
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return "Portafolio de cuentas de " + getNombreCliente() + " con " + cuentas.size() + " cuentas";
    }
    
}
