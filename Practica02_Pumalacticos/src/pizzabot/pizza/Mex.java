package pizzabot.pizza;

/**
 * Clase que representa una pizza a la mexicana que esta extendida de la clase PrepararPizza
 * implementando los pasos de preparación de una pizza comun
 */
public class Mex extends PrepararPizza{
    private String sabor = "Mexicana";
    private String masa;

    /**
     * Crea una pizza a la mexicana, en base a una masa elegida
     * @param masa El tipo de masa que se usara para la pizza
     */
    public Mex(String masa){
        this.masa = masa;
    }
   
    /**
     * Prepara la masa de la pizza e imprime un mensaje diciendo que esta haciendo
     */
    protected void prepararMasa(){
        System.out.println("Preparando masa " + masa);
    }

    /**
     * Aplana la masa e imprime un mensaje indicando que lo esta haciendo
     */
    protected void aplanarMasa(){
        System.out.println("Aplanando masa");
    }

    /**
     * Coloca la salsa de tomate e imprime que lo esta haciendo
     */
    protected void colocarSalsaDeTomate(){
        System.out.println("Colocando salsa de Tomate");
    }

    /**
     * Coloca el queso e imrpime que lo esta haciendo
     */
    protected void colocarQueso(){
        System.out.println("Colocando queso");
    }

    /**
     * Coloca las especias e imprime que lo esta haciendo 
     */
    protected void colocarEspecias(){
        System.out.println("Colocando pimienta roja");
    }

    /**
     * Coloca la proteina indicada e imprime que lo esta haciendo
     */
    protected void colocarProteina(){
        System.out.println("Colocando Champiñones");
    }

    /**
     * Pone la pizza en el horno e indica que lo esta haciendo
     */
    protected void meterAlHorno(){
        System.out.println("Metiendo pizza al horno");
    }

    /**
     * Imprime que esta en un estado de espera
     */
    protected void esperar(){
        System.out.println("Esperando...");
    }

    /**
     * Saca la pizza del horno e imprime que lo esta haciendo
     */
    protected void sacarDelHorno(){
        System.out.println("Sacando pizza del horno");
    }

    /**
     * Pone la pizza en su pizza e imprime que lo esta haciendo
     */
    protected void empaquetar(){
        System.out.println("Empaquetando su deliciosa pizza");
    }

    /**
     * Indica si la pizza es vegetariana
     * @return <false> porque tiene carne
     */
    protected boolean esVegetariana(){
        return false;
    }
    
    /**
     * Regresa una pequeña descripción de la pizza preparada
     * @return un string de la descripción
     */
    public String getDescripcion(){
        return "Pizza a la mexicana";
    }

    /**
     * Checa el sabor de la pizza cocinada
     * @return el sabor de la pizza
     */
    public String getSabor(){
        return sabor;
    }
    
    /**
     * Checa el precio de la pizza
     * @return el precio de la pizza en base a la cual es
     */
    public int getPrecio(){
        return 299;
    }

}