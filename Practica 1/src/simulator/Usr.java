package simulator;

import simulator.Service;
import java.util.HashMap;

public class Usr implements Observer{
    public HashMap<String, Service> services = new HashMap<>();
    private String userName;
    private Integer money;
    private FPrinter fp;
    private int month = 1;

    /**
     * Método constructor
     * @param userName El nombre que tendrá esta instancia en representación de un usuario.
     * @param money The initial money ammount of the user.
     */
    public Usr(String userName, Integer money){
        this.userName = userName;
        this.money = money;
        this.fp = new FPrinter(userName+"Operations.txt");
    }
    

    /**
     * @param service The service that it's going to get fetched to get the ID 
     **/
    public void subscribe(Service service){
        String serv = service.getId();
        if(services.containsKey(serv)){ // if the service's id is in the hashMap key's then is already stored an instance of that service
            (services.get(service.getId())).setStatus(true); //this line obtains the service by the given service ID, and then set its status to true.
            fp.printnl("Welcome back " + userName + " to " + (services.get(serv)).getService());
        } else{
            services.put(service.getId(), service);
            fp.printnl(userName + " signed up for " + (services.get(serv)).getService());
        }
    }

    /**
     * Get's the ID of the service and changes the statue of the subscription to that service to <true>
     * @param id The service ID of the service that the user is going to subscribe
     **/
    public void subscribe(String id){
        (services.get(id)).setStatus(true);
    }

    /**
     * Get's the ID of the service and changes the statue of the subscription to that service to <false>
     * @param id The service ID of the service that the user is going to unsubcribe
     */
    public void unsubscribe(String id){
        (services.get(id)).setStatus(false);
        fp.printnl("In " + id + " we are sorry for your departure " + userName);
    }

    /***
     * Checks that the user has enough money to continue the subscription, and if the user doesn't have the enough money they get unsubscribe from that service
     */
    public void update(){
        if(month == 1){
            fp.printnl("");
            fp.printnl("==== Inicio ====");
            fp.printnl("");
        }
        for (Service service : services.values()) {
            if(money - service.getPrice() < 0 && service.getStatus()){
                unsubscribe(service.getId());
            } else{
                cashIn(service);
                service.update();
            }
        }
        fp.printnl("");
        fp.printnl("==== fin del mes "+month+" ====");
        fp.printnl("");
        month++;
    }

    /**
     * Substracts the price of a service to the money of the user 
     * @param service The monetary cuantity of the subscription of the service 
     */
    private void cashIn(Service service){
        money = money - service.getPrice();
        fp.printnl(userName + " paid "+ service.getPrice() + " for " + service.getService());
        fp.printnl(service.getId() + " recommends " + service.getRecommendation() + " to "+userName);
        return;
    }

    /**
     * @return returns the money of the user
     */
    public int getMoney(){
        return money;
    }

    /**
     * @return returns the name of the user
     */
    public String getName(){
        return userName;
    }
}