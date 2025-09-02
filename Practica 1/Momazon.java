package simulator;

public class Momazon implements Service{
    int price;
    String service;
    public Momazon(int price){
        this.price = price;
        if(price == 110){
            service = "Momazon Prime Normal";
        } else if(price == 170){
            service = "Momazon Prime Premium";
        }
    }
}
