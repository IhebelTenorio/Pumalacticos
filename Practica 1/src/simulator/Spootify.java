package simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Spootify implements Service{
    Random random = new Random();
    private int price;
    private String service;
    private boolean isActive = true;
    List<String> listota = new ArrayList<>(
            Arrays.asList("I'll take care of you", "Don't you worry", "Ghost Town", " Diles", "Manifesto", "Thought I was dead", "Despues de la playa","Like Him","Darling, I","Glitter","Carnival","Baile Inolvidable","Sorry not sorry","Judge Judy","Wesley's Theory","meet the grahams","Stop playing with me","Euphoria","Ring ring ring","Luther")
        );

    /**
     * @param isPremium object that will show if the service has a premium status or not
     */
    public Spootify(boolean isPremium){
        if(isPremium){
            price = 80;
            service = "Spootify Premium";
        } else {
            price = 0;
            service = "Spootify SPAM";
        }
    }

    public int getPrice(){
        return price;
    }

    public String getService(){
        return service;
    }

    public void update(){
    }

    public String getId(){
        return "Spootify";
    }

    public boolean getStatus(){
        return isActive;
    }

    public void setStatus(boolean toggleTo){
        isActive = toggleTo;
        if(toggleTo){
            price = 80;
            service = "Spootify Premium";
        } else {
            price = 0;
            service = "Spootify SPAM";
        }
    }

    public String getRecommendation(){
        int numero = random.nextInt(listota.size());
        String elegido = listota.get(numero);
        listota.remove(numero);
        return elegido;
    }
    
}
