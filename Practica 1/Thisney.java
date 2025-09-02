package simulator;

public class Thisney implements Service{
    int price;
    String service;
    public Thisney(int price){
        this.price = price;
        if(price == 130){
            service = "Thisney+ New User";
        } else if(price == 160){
            service = "Thisney+";
        }
    }
}
