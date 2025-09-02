package simulator;

//import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Usr{
    public List<Service> suscriptions = new ArrayList<Service>();
    public List<String> cancelled = new ArrayList<String>();
    private String userName;
    private Integer money;

    /**
     * Método constructor
     * @param userName El nombre que tendrá esta instancia en representación de un usuario.
     */
    public Usr(String userName, Integer money){
        this.userName = userName;
        this.money = money;
    }
    
    public void subscribe(Service service){
        suscriptions.add(service);
    }

    private void unsubscribe(){
        
    }
}