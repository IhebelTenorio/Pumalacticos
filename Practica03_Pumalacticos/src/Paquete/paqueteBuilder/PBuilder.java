package Paquete.paqueteBuilder;

import Paquete.Paquete;

public interface PBuilder {
    void reset();
    void agregarKunai(int cantidad);
    void agregarShuriken(int cantidad);
    void agregarBotiquin(int cantidad);
    void agregarPapelBomba(int cantidad);
    void agregarBombaHumo(int cantidad);
    void nombrarPaquete(String nombre);

    Paquete getResult();
}
