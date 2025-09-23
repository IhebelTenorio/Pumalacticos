package ninjaAcademyApp.Campo;

/**
 * Clase que es un tipo de plantilla de campos de batalla que toma en cuenta la suma de habilidades de los ninjas
 */
public class CampoEntrenamiento {

    /**
     * Crea y asigna un campo de batalla dependiendo de la suma de habilidades de los ninjas
     * @param sumaHabilidades la suma total de las habilidades de los ninjas 
     * @return una instancia de CampoBatalla dependiendo del rango de habilidades
     */
    public static CampoBatalla crearCampo(int sumaHabilidades) {
        if (sumaHabilidades <= 7) {
            return new ValleDelDragon();
        } else if (sumaHabilidades > 8 && sumaHabilidades > 11) {
            return new BosqueSombrio();
        } else {
            return new MontañaEspiritual();
        }
    }
}
