package simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Momazon implements Service{
    Random random = new Random();

    int price;
    String service;
    private boolean isActive = true;
    List<String> listota = new ArrayList<>(
            Arrays.asList("The Boys","The Lord of the Rings: The Rings of Power","The Terminal List", "Four More Shots Please!","Mirzapur","Reacher","The Marvelous Mrs. Maisel","Fleabag","Fallout","The Summer I Turned Pretty","Maxton Hall-The World Between Us","Gen V","Upload","Dead Ringers","Outer Range","I'm a Virgo","Pulp Fiction", "The pickup", "The endless", "Miami vice")
        );

    /**
     * @param isPremium object that will show if the service has a premium status or not
     */
    public Momazon(boolean isPremium){
        if(isPremium){
            price = 110;
            service = "Momazon Prime Normal";
        } else {
            price = 150;
            service = "Momazon Prime Premium";
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
        return "Momazon";
    }

    public boolean getStatus(){
        return isActive;
    }

    /**
     * @param toggleTo
     */
    public void setStatus(boolean toggleTo){
        isActive = toggleTo;
    }

    public String getRecommendation(){
        int numero = random.nextInt(listota.size());
        String elegido = listota.get(numero);
        listota.remove(numero);
        return elegido;
    }
}
