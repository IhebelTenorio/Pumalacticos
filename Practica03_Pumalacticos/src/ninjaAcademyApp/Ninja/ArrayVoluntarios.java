package ninjaAcademyApp.Ninja;

import java.util.Iterator;
import ninjaAcademyApp.Iterators.*;

/**
 * Clase que maneja un arreglo de objetos de tipo Voluntario
 */
public class ArrayVoluntarios {
    private Voluntario[] voluntarios;
    private int posicion = 0;

    /**
     * Crea un nuevo arreglo con una capacidad indicada
     * @param tamañoMaximo número máximo que se pueden contener de voluntarios
     */
    public ArrayVoluntarios(int tamañoMaximo) {
        voluntarios = new Voluntario[tamañoMaximo];
    }

    /**
     * Agrega un voluntario al arreglo en caso de que haya espacio disponible
     * @param v voluntario que se va a añadir
     */
    public void agregarVoluntario(Voluntario v) {
        if (posicion < voluntarios.length) {
            voluntarios[posicion] = v;
            posicion++;
        }
    }

    /**
     * Crea un iterador que recorre el arreglo de voluntarios
     * @return iterador de Voluntario
     */
    public Iterator crearIterador() {
        return new VoluntarioIterator(voluntarios);
    }
}