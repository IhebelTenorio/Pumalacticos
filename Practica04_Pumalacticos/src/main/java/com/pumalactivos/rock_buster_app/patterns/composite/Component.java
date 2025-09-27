package src.main.java.com.pumalactivos.rock_buster_app.patterns.composite;

/**
 * Define el contrato del arbol que representará a las películas y sagas
 */
public interface Component {
    public String getNombre();
    public String getDirector();
    public int getDuracion();
    public String getGenero();
    public String getSinopsis();
    public double getPrecioRenta();
}
