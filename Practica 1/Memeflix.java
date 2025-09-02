package simulator;

public class Memeflix implements Service{
    int price;
    String service;
    public Memeflix(int price){
        this.price = price;
        if(price == 120){
            service = "Memeflix 1 dispositivo";
        } else if(price == 170){
            service = "Memeflix 2 dispositivos";
        } else if(price == 200){
            service = "Memeflix 4 dispositivos";
        }
    }
}

