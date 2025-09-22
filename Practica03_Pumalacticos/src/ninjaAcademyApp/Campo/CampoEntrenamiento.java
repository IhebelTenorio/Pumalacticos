package ninjaAcademyApp.Campo;

public class CampoEntrenamiento {
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
