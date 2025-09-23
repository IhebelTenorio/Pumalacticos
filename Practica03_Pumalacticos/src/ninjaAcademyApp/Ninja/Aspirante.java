package ninjaAcademyApp.Ninja;

/**
 * Clase que representa a un ninja aspirante que hereda de la clase abstracta de Konoha
 */
public class Aspirante extends Konoha {

    /**
     * Crea un nuevo aspirante 
     * @param nombre nombre del aspirante
     * @param edad edad del aspirante 
     * @param clan clan de origen del aspirante
     * @param nivelHabilidad nivel de habilidad del aspirante
     */
    public Aspirante(String nombre, int edad, String clan, int nivelHabilidad){
        super(nombre, edad, clan, nivelHabilidad);
    }
    
    /**
     * Regresa una cadena de texto de los datos heredados 
     * @return informacion heredada concatenada con una cadena de texto
     */
    public String toString() {
        return super.toString() + " Aspirante";
    }
}