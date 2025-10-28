package PUMABANK.observer;

public interface NotificadorCuenta {
    /**
     * Adjunta un observador a la lista.
     * @param observer El observador a adjuntar.
     */
    void adjuntar(ReceptorNotificacion observer);

    /**
     * Desvincula un observador de la lista.
     * @param observer El observador a desvincular.
     */
    void desvincular(ReceptorNotificacion observer);

    /**
     * Notifica a todos los observadores adjuntos sobre un evento.
     * @param evento El mensaje del evento.
     */
    void notificar(String evento); 
}