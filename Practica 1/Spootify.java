package simulator;

public class Spootify implements Service{
    int price;
    String service;
    public Spootify(int price){
        this.price = price;
        if(price == 0){
            service = "Spootify Gratis";
        } else if(price == 80){
            service = "Spootify Premium";
        }
    }
}
