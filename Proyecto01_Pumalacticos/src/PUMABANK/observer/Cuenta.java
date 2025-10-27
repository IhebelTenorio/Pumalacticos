package PUMABANK.observer;

import java.util.List;
import java.util.ArrayList;

public class Cuenta implements NotificadorCuenta{

    private List<ReceptorNotificacion> observadores = new ArrayList<>();
    private String estadoCuenta = "Activa";

    @Override
    public void adjuntar(ReceptorNotificacion observador){
        observadores.add(observador);
    }

    @Override
    public void desvincular(ReceptorNotificacion observador){
        observadores.remove(observador);
    }

    @Override
    public void notificar(String mensaje){
        System.out.println("\n Notificar a: " + observadores.size() + " obsrevadores sobre: " + mensaje);
        for(ReceptorNotificacion obs : observadores){
            obs.actualizar(mensaje);
        }
    }

    public void realizarCompra(double monto){

        if(this.saldo < monto){
            this.estadoCuenta = "Sobregirada";
            String mensaje = "Su tarjeta a sido sobregirada y su cuenta paso a estado de sobregiro";
            notificar(mensaje);
        }
        else{
            this.saldo -= monto;
            String mensaje  ="Compra por $" + monto + " realizada correctamente";
            notificar(mensaje);
        }
    }

    public void marcarCongelada(){
        this.estadoCuenta = "Congelada";
        String mensaje = "Su cuenta ha sido congelada";
        notificar(mensaje);
    }
    
}
