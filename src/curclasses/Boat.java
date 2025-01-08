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
        if (ob==null) return false;
        if (getClass() != ob.getClass()) return false;
        Boat o = (Boat) ob;
        if (!super.equals(o)) return false;
        return (this.toString().equals( o.toString()) && this.getCapacity().equals(o.getCapacity()));

    }

    @Override
    public int hashCode(){
        return 31 + capacity.hashCode() +signal.hashCode() + toString().hashCode();
    }


    public static void main(String[] args) {
        var b1 = new Boat("name1");
        b1.setSignal("1");
        var b2 = new Boat("name1");
        b2.setSignal("1");
        System.out.println(b1.equals(b2));
    }
}
