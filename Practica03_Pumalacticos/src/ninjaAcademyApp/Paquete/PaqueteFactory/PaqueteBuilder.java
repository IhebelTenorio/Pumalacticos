package ninjaAcademyApp.Paquete.PaqueteFactory;
import ninjaAcademyApp.Paquete.Paquete;

public interface PaqueteBuilder {
    
    void agregarKunai(int cantidad);
    void agregarShuriken(int cantidad);
    void agregarBotiquin(int cantidad);
    void agregarPapelBomba(int cantidad);
    void agregarBombaHumo(int cantidad);

    Paquete build();

}
