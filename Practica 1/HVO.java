package simulator;

public class HVO implements Service{
    int price;
    String service;
    public HVO(int price){
        this.price = price;
        if(price == 0){
            service = "HVO Max Prueba";
        } else if(price == 140){
            service = "HVO Max";
        }
    }
}
