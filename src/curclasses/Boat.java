package curclasses;

import java.util.ArrayList;

public class Boat extends Item {
    private ArrayList<Resource> capacity;
    private String signal;

    public Boat(String name){
        super(name);
        capacity = new ArrayList<Resource>();
    }

    public ArrayList<Resource> getCapacity() {
        return capacity;
    }

    public void setCapacity(ArrayList<Resource> capacity) {
        this.capacity = capacity;
    }
    @Override
    public String use(){
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }
    //hashcode

    @Override
    public boolean equals(Object ob){
        if (this == ob) return true;
        if (getClass() != ob.getClass() || hashCode() != ob.hashCode()) return false;
        Boat o = (Boat) ob;
        if (this.toString() == o.toString() && this.getCapacity().equals(o.getCapacity())) return true;
        return false;
    }

    @Override
    public int hashCode(){
        return 31 + capacity.hashCode() +signal.hashCode() + toString().hashCode();
    }
}
