package simulator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Thisney implements Service{
    Random random = new Random();

    private int price = 130;
    private String service = "Thisney+ (Discount)";
    private int month;
    private boolean isActive = true;
    List<String> listota = new ArrayList<>(
            Arrays.asList("Loki", "The Mandalorian", "WandaVision", "Moon Knight", "Andor", "Hawkeye", "What If...?", " The Falcon and the Winter Soldier", "She-Hulk", "Ms.Marvel", "Ahsoka", "Baymx!", "Big Hero 6: The Series", "X-Men 97", "Agatha All Along", "Ironheart", "Percy Jackson", "Daredevil: Born Again", "Eyes of Wakanda", "Stars Wars: Tales of the Underwolrd")
        );

    public Thisney(){
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
            price = 160;
            service = "Thisney+";
        }

    }

    public String getId(){
        return "Thisney";
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
