package PUMABANK.iteratorComposite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import PUMABANK.Cuenta;
import PUMABANK.decorator.ICuenta;
import PUMABANK.decorator.RecompensasDecorator;
import PUMABANK.decorator.SeguroAntifraudeDecorator;
import PUMABANK.proxy.CuentaProxy;
import PUMABANK.strategy.EstrategiaInteresMensual;
import PUMABANK.strategy.IEstrategiaInteres;

public class Registro implements Iterable<ICuenta>{
    private HashMap<String,CuentaProxy> proxys;

    public Registro(){
        proxys = generarProxys();
    }

    public CuentaProxy get(String s){
        return proxys.get(s);
    }

    @Override
    public Iterator<ICuenta> iterator() {
        return new IteradorCuentas(new ArrayList<>(proxys.values()));
    }



    // TODO javadoc
    private static HashMap<String, CuentaProxy> generarProxys(){
        HashMap<String, CuentaProxy> cuentas = new HashMap<>();
                // estrategia
        IEstrategiaInteres mensual = new EstrategiaInteresMensual();
        
        // cuenta base (Componente Concreto)
        ICuenta cuentaBase = new Cuenta("PUMALACTICO 001", "Cliente 1", 5000, mensual);

        // Decoramos (opcional)
        ICuenta cuentaDecorada = new RecompensasDecorator(new SeguroAntifraudeDecorator(cuentaBase));

        //Creamos el Proxy, "envolviendo" al objeto real (decorado)
        // El NIP "1234" está quemado aquí por simplicidad.
        CuentaProxy miCuentaProxy = new CuentaProxy(cuentaDecorada, "1234");

        // la variable que usaremos es 'miCuentaProxy'
        cuentas.put(cuentaBase.getNumeroDeCuenta(), miCuentaProxy);


        IEstrategiaInteres estrategiaUsuario2 = new EstrategiaInteresMensual();
        ICuenta cuentaBase2 = new Cuenta("SUPER_NOVA 002", "Cliente 1", 15000, estrategiaUsuario2);
        ICuenta cuentaDecorada2 = new RecompensasDecorator(cuentaBase2); // Solo un decorador
        CuentaProxy cuentaProxy2 = new CuentaProxy(cuentaDecorada2, "2468"); // NIP: "2468"
        cuentas.put(cuentaBase2.getNumeroDeCuenta(), cuentaProxy2);
        
        // Usuario 2: "Cliente 3"
        IEstrategiaInteres estrategiaUsuario3 = new EstrategiaInteresMensual();
        ICuenta cuentaBase3 = new Cuenta("GALAXIA_M31 003", "Cliente 2", 500, estrategiaUsuario3);
        ICuenta cuentaDecorada3 = new SeguroAntifraudeDecorator(cuentaBase3); // Solo un decorador
        CuentaProxy cuentaProxy3 = new CuentaProxy(cuentaDecorada3, "1357"); // NIP: "1357"
        cuentas.put(cuentaBase3.getNumeroDeCuenta(), cuentaProxy3);
        
        // Usuario 3: "Cliente 4"
        IEstrategiaInteres estrategiaUsuario4 = new EstrategiaInteresMensual();
        ICuenta cuentaBase4 = new Cuenta("ANDROMEDA 004", "Cliente 2", 75000, estrategiaUsuario4);
        // Decoración opcional: sin decoradores en este caso
        CuentaProxy cuentaProxy4 = new CuentaProxy(cuentaBase4, "0000"); // NIP: "0000"
        cuentas.put(cuentaBase4.getNumeroDeCuenta(), cuentaProxy4);
        
        // Usuario 4: "Cliente 5"
        IEstrategiaInteres estrategiaUsuario5 = new EstrategiaInteresMensual();
        ICuenta cuentaBase5 = new Cuenta("NEBULA_DE_ORION 005", "Cliente 3", 2500, estrategiaUsuario5);
        ICuenta cuentaDecorada5 = new RecompensasDecorator(new SeguroAntifraudeDecorator(cuentaBase5)); // Ambos decoradores
        CuentaProxy cuentaProxy5 = new CuentaProxy(cuentaDecorada5, "9999"); // NIP: "9999"
        cuentas.put(cuentaBase5.getNumeroDeCuenta(), cuentaProxy5);
        // Usuario 1: "Cliente 2"
        

        // Creamos 2 portafolios
        ArrayList<ICuenta> c = new ArrayList<>();
        c.add(cuentaDecorada);
        c.add(cuentaDecorada2);
        Portafolios port1 = new Portafolios("PORT_C1",c);
        CuentaProxy port1Proxy = new CuentaProxy(port1, "7777");
        cuentas.put(port1Proxy.getNumeroDeCuenta(),port1Proxy);

        c.clear();
        c.add(cuentaDecorada3);
        c.add(cuentaBase4);
        Portafolios port2 = new Portafolios("PORT_C2", c);
        CuentaProxy port2Proxy = new CuentaProxy(port2, "8888");
        cuentas.put(port2Proxy.getNumeroDeCuenta(),port2Proxy);
        c.clear();

        
        return cuentas;
    }

}
