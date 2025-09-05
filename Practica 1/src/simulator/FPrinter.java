package simulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FPrinter {
    
    private File file;

    public FPrinter(String path){
        file = new File(path);
        try (FileWriter cleaner = new FileWriter(file, false)) { // false = sobrescribir
            // No escribimos nada → deja el archivo vacío
            System.out.println("Archivo inicializado vacío: " + file.getName());
        } catch (IOException e) {
            System.out.println("Error al inicializar archivo.");
            e.printStackTrace();
        }
    }

    public void printnl(String s){
            try (FileWriter writer = new FileWriter(file, true)) { // true = append
                writer.write(s + "\n");
            } catch (IOException e) {
                System.out.println("Error at writing File");
                e.printStackTrace();
            }
    }
}
