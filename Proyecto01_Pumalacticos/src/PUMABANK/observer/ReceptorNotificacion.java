package PUMABANK.observer;

public interface ReceptorNotificacion {
    /**
     * Método que el Sujeto llamará cuando ocurra un evento.
     * @param evento Descripción del evento.
     */
    public void actualizar(String evento);
}
