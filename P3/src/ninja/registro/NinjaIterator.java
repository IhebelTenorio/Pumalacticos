package ninja.registro;

import java.util.ArrayList;
import java.util.List;

import ninja.Ninja;

public class NinjaIterator{
    private List<Ninja> ninjas;
    private int i;

    public NinjaIterator(List<Ninja> ninjas){
        this.ninjas = new ArrayList<>();
        this.ninjas.addAll(ninjas);
        this.i = 0;
    }

    public boolean hasNext(){
        return ninjas.size() > i;
    }

    public Ninja next(){
        Ninja ninja = ninjas.get(i);
        i++;
        return ninja;
    }
    
}
