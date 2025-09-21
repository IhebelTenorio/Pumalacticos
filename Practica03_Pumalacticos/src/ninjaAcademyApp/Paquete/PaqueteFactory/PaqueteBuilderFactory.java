package ninjaAcademyApp.Paquete.PaqueteFactory;


public class PaqueteBuilderFactory {
    public static PaqueteBuilder crearBuilder(String tipo){
        
        switch (tipo) {
            case "Basico":
            return new PaqueteBasicoBuilder();

            case "Avanzado":
            return new PaqueteAvanzadoBuilder();
            
            case "Tactico":
            return new PaqueteTacticoBuilder();

            //case "Custom":
            //return new PaqueteCustomBuilder();

            default:
            return null;
        }
    }
    
}
