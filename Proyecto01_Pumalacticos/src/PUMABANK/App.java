package PUMABANK;

import PUMABANK.decorator.*;
import PUMABANK.strategy.*;

public class App {
    public static void main(String[] args) {
        
        // Estrategia de interés primero
        IEstrategiaInteres estrategiaMensual = new EstrategiaInteresMensual();

        // Cuenta base (El "Componente Concreto")
        //    Nota: la variable es de tipo ICuenta (la abstracción)
        ICuenta cuentaCliente1 = new Cuenta(
            "001", "Cliente Básico", 15000, estrategiaMensual
        );
        
        System.out.println(cuentaCliente1.getDescripcion());
        cuentaCliente1.retirar(120000); // Retiro grande
        
        System.out.println("\n-------------------------\n");

        // Cuenta DECORADA 
        ICuenta cuentaCliente2 = new Cuenta(
            "002", "Cliente Premium", 15000, estrategiaMensual
        );
        
        // Recompensas
        cuentaCliente2 = new RecompensasDecorator(cuentaCliente2);
        
        // Seguro Antifraude
        cuentaCliente2 = new SeguroAntifraudeDecorator(cuentaCliente2);
        
        System.out.println(cuentaCliente2.getDescripcion());
        
        // Probamos el depósito (activará Recompensas)
        cuentaCliente2.depositar(1000); 
        
        // Probamos el retiro (activará el Seguro)
        cuentaCliente2.retirar(120000); 
        
        System.out.println("\n-------------------------\n");
        // Vemos la descripción final
        System.out.println(cuentaCliente2.getDescripcion());
    }
}