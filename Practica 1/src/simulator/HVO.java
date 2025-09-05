package simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HVO implements Service{
    Random random = new Random();

    int price;
    String service;
    int month = 0;

    private boolean isActive = true;

    List<String> listota = new ArrayList<>(
            Arrays.asList("Peacemaker","The last of us","Succession","The sopranos","The wire","Game of thrones","The penguin","The white lotus","Scavengers reign","Barry","Rage","Iyanu","Prime minister","Aztec Batman: clash of empires","The yogurt shop murders", "Ruby & Jodi","The gilded age","Duster","Harley QUinn","The batman")
        );

    public HVO(){
        service = "HVO free trial";
    }
    public int getPrice(){
        return price;
    }

    public String getService(){
        return service;
    }

    public void update(){
        month++;
        if(month == 3){
            price = 140;
            service = "HVO";
        }
    }

    public String getId(){
        return "HVO";
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
