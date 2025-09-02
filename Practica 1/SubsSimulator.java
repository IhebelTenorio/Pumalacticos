package simulator;
import java.util.ArrayList;
//No eres un 1/2cre <3
import java.util.List;

// Make sure User is imported if it's in another package
// import simulator.User; // Uncomment if User is in simulator package

public class SubsSimulator {
    public static void main(String[] args){
        // Creating the program user's
        Usr alicia = new Usr("Alicia",15000);
        alicia.subscribe(new Memeflix(120));
    }
}
