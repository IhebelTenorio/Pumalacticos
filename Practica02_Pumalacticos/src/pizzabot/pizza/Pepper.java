package pizzabot.pizza;

public class Pepper extends PrepararPizza{
    private String sabor = "pepperoni";
    private String masa;
    public Pepper(String masa){
        this.masa = masa;
    }

    protected void prepararMasa(){
        System.out.println("Preparando masa "+masa);
    }
    protected void aplanarMasa(){
        System.out.println("Aplanando masa");
    }
    protected void colocarSalsaDeTomate(){
        System.out.println("Colocando salsa de Tomate");
    }
    protected void colocarQueso(){
        System.out.println("Colocando queso");
    }
    protected void colocarEspecias(){
        System.out.println("Colocando pimienta roja");
    }
    protected void colocarProteina(){
        System.out.println("Colocando Pepperoni");
    }
    protected void meterAlHorno(){
        System.out.println("Metiendo pizza al horno");
    }
    protected void esperar(){
        System.out.println("Esperando...");
    }
    protected void sacarDelHorno(){
        System.out.println("Sacando pizza del horno");
    }
    protected void empaquetar(){
        System.out.println("Empaquetando su deliciosa pizza");
    }

    public String getSabor(){
        return sabor;
    }

    public int getPrecio(){
        return 120;
    }
    
    
    
    
}
