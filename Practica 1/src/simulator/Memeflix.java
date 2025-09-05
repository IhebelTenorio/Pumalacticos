package simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Memeflix implements Service{
    Random random = new Random();

    int price;
    String service;
    private boolean isActive = true;
    List<String> listota = new ArrayList<>(
            Arrays.asList("Stranger Things","The Witcher","Squid Game","Wednesday","Money Heist (La Casa de Papel)","Bridgerton","Lupin","The Queen's Gambit","Dark","Black Mirror","Arcane","One Piece (Live Action)","Narcos","Elite","Sex Education","Outer Banks","Avatar: The Last Airbender (Live Action)","Cobra Kai","Extraction 2","Society of the Snow"));    /**
     * @param devices object that will decide, based on its value, the number of devices checked in the users plan
     */
    public Memeflix(int devices){
        if(devices == 1){
            price = 120;
            service = "Memeflix 1 dispositivo";
        } else if(devices == 2){
            price = 170;
            service = "Memeflix 2 dispositivos";
        } else if(devices == 4){
            price = 200;
            service = "Memeflix 4 dispositivos";
        }
    }

    public int getPrice(){
        return price;
    }

    public String getService(){
        return service;
    }

    public void update(){}

    public String getId(){
        return "Memeflix";
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
