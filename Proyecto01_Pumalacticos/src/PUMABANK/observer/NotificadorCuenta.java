package PUMABANK.observer;

public interface NotificadorCuenta {

    public void adjuntar(ReceptorNotificacion observador);
    public void desvincular(ReceptorNotificacion obsservador);
    //public void notificar(Evento evento);
}
