package PUMABANK.observer;

public class NotificadorEmail implements ReceptorNotificacion{
    
    @Override
    public void actualizar(String evento){
        System.out.println("Se envio un corre con el detalle del evento " + evento);
    }
    
}
