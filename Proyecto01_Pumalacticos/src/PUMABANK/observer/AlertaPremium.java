package PUMABANK.observer;

public class AlertaPremium implements ReceptorNotificacion{

    @Override
    public void actualizar(String evento){
        System.out.println("Alerta premium: " + evento);
    }
    
}
