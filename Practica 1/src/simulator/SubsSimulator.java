package simulator;
import java.util.ArrayList;
import java.util.List;

public class SubsSimulator {
    private static List<Usr> users= new ArrayList<Usr>();

    public static void main(String[] args){
        
        // Creating the program user's
        // Month 0
        Usr alicia = new Usr("Alicia",15000);
        users.add(alicia);
        alicia.subscribe(new Momazon(true));
        alicia.subscribe(new HVO()); // Prueba gratis
        alicia.subscribe(new Memeflix(4));
        alicia.subscribe(new Spootify(true));
        alicia.subscribe(new Thisney());

        Usr bob = new Usr("Bob", 2400);
        users.add(bob);
        bob.subscribe(new Memeflix(1));
        bob.subscribe(new Momazon(true));
        bob.subscribe(new HVO()); // Prueba gratis
        bob.subscribe(new Spootify(true));
        bob.subscribe(new Thisney());

        Usr cesar = new Usr("César", 5000);
        users.add(cesar);
        cesar.subscribe(new Thisney());
        cesar.subscribe(new HVO());

        Usr diego = new Usr("Diego", 9000);
        users.add(diego);
        diego.subscribe(new HVO());
        diego.subscribe(new Momazon(true));
        diego.subscribe(new Spootify(false));

        Usr erika = new Usr("Erika", 10000);
        users.add(erika);
        erika.subscribe(new Memeflix(4)); 
        erika.subscribe(new Spootify(false));
        erika.subscribe(new HVO());

        Usr fausto = new Usr("Fausto", 5000);
        users.add(fausto);
        fausto.subscribe(new Thisney());
        fausto.subscribe(new HVO());
        
        // Month 1
        updateUsers();

        // Month 2
        updateUsers();

        // Month 3
        updateUsers();
        bob.unsubscribe("Thisney");
        bob.unsubscribe("HVO");
        erika.unsubscribe("HVO");
        erika.subscribe(new Thisney());
        fausto.unsubscribe("Thisney");
        fausto.unsubscribe("HVO");
        fausto.subscribe(new Memeflix(1));

        // Month 4
        updateUsers();
        bob.unsubscribe("Memeflix");
        bob.unsubscribe("Momazon");

        // Month 5
        updateUsers();
        fausto.subscribe(new Thisney());
        fausto.subscribe(new HVO());

        // Month 6
        updateUsers();
        diego.subscribe(new Thisney());
        erika.unsubscribe("Thisney");
        erika.unsubscribe("Memeflix");
        erika.unsubscribe("Spootify");
        fausto.unsubscribe("Thisney");
        fausto.unsubscribe("HVO");
        fausto.unsubscribe("Memeflix");


        // Month 7
        updateUsers();
        cesar.subscribe(new Spootify(true));
        diego.subscribe(new Memeflix(1));
        diego.subscribe("Spootify");
        diego.unsubscribe("Momazon");
        
        // Month 8
        updateUsers();

        // Month 9
        updateUsers();

        // Month 10
        updateUsers();
        erika.subscribe(new Momazon(true));
        erika.subscribe("HVO");
        erika.subscribe("Thisney");

        for(int i = 0; i<5; i++){ // We update for 5 months more
            updateUsers();
        }

    }

    
    private static void updateUsers(){
        for(Usr usr : users) {
            usr.update();
        }
    }
}
