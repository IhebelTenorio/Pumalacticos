package ninjaAcademyApp.Ninja;

/**
 * Clase que representa a un ninja voluntario que hereda de la clase abstracta Konoha
 */
public class Voluntario extends Konoha {
    private String rango;
    
    /**
     * Crea un nuevo objeto de tipo Voluntario
     * @param nombre nombre del voluntario 
     * @param edad edad del voluntario
     * @param clan clan de origen del voluntario
     * @param nivelHabilidad nivel de habilidad del voluntario 
     * @param rango rango del voluntario
     */
    public Voluntario(String nombre, int edad, String clan, int nivelHabilidad, String rango){
        super(nombre, edad, clan, nivelHabilidad);
        this.rango = rango;
    }

    /**
     * Obtiene el rango del voluntario
     * @return rango del voluntario 
     */
    public String getRango(){
        return rango;
    }
    
    /**
     * Regresa un String del rango del voluntario 
     * @return cadena de texto concatenado con el rango del voluntario
     */
    public String toString() {
        return super.toString() + " Voluntario [rango=" + rango + "]";
    }   
    
}
