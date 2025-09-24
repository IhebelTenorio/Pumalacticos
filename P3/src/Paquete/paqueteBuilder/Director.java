package Paquete.paqueteBuilder;

import java.util.Scanner;

import Paquete.Paquete;

public class Director {
    private PBuilder builder;

    public Director(PBuilder builder){
        this.builder = builder;
    }

    public Paquete construirBasico(){
        builder.reset();
        builder.nombrarPaquete("Básico");
        builder.agregarKunai(1);
        builder.agregarShuriken(1);
        builder.agregarBotiquin(1);
        return builder.getResult();
    }

    public Paquete construirAvanzado(){
        builder.reset();
        builder.nombrarPaquete("Avanzado");
        builder.agregarShuriken(2);
        builder.agregarBotiquin(2);
        builder.agregarPapelBomba(3);
        builder.agregarBombaHumo(2);
        return builder.getResult();
    }

    public Paquete construirTactico(){
        builder.reset();
        builder.nombrarPaquete("Táctico");
        builder.agregarKunai(3);
        builder.agregarShuriken(4);
        builder.agregarPapelBomba(4);
        builder.agregarBombaHumo(2);
        return builder.getResult();
    }

    public Paquete construirCustom(){
        builder.reset();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("¿Cuántas Kunai deben ir en el paquete? Escriba un numero mayor o igual a 0");
            builder.agregarKunai(sc.nextInt());
            System.out.println("¿Cuántas Shuriken deben ir en el paquete? Escriba un numero mayor o igual a 0");
            builder.agregarShuriken(sc.nextInt());
            System.out.println("¿Cuántos Botiquines deben ir en el paquete? Escriba un numero mayor o igual a 0");
            builder.agregarBotiquin(sc.nextInt());
            System.out.println("¿Cuántos Papeles bomba deben ir en el paquete? Escriba un numero mayor o igual a 0");
            builder.agregarPapelBomba(sc.nextInt());
            System.out.println("¿Cuántas Bombas de Humo deben ir en el paquete? Escriba un numero mayor o igual a 0");
            builder.agregarBombaHumo(sc.nextInt());
            System.out.print("¿Cómo debe llamarse este paquete? Escriba un texto");
            builder.nombrarPaquete(sc.nextLine());
        }
        
        return builder.getResult();
    }

}
