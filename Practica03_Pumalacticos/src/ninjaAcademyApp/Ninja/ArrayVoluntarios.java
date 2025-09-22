package ninjaAcademyApp.Ninja;

import java.util.Iterator;
import ninjaAcademyApp.Iterators.*;

public class ArrayVoluntarios {
    private Voluntario[] voluntarios;
    private int posicion = 0;

    public ArrayVoluntarios(int tamañoMaximo) {
        voluntarios = new Voluntario[tamañoMaximo];
    }

    public void agregarVoluntario(Voluntario v) {
        if (posicion < voluntarios.length) {
            voluntarios[posicion] = v;
            posicion++;
        }
    }

    public Iterator crearIterador() {
        return new VoluntarioIterator(voluntarios);
    }
}