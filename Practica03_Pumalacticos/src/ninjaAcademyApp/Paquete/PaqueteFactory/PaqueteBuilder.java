package ninjaAcademyApp.Paquete.PaqueteFactory;
import ninjaAcademyApp.Paquete.Paquete;

public interface paqueteBuilder {
    
    void agregarKunai();
    void agregarShuriken();
    void agregarBotiquin();
    void agregarPapelBomba();
    void agregarBombaHumo();

    public Paquete build();

}
