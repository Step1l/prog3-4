package curclasses;

import records.Time;

import java.util.ArrayList;

public class Envoys {
    private String name;
    private Boat boat;

    public Envoys(String name, Boat boat) {
        this.name = name;
        this.boat = boat;
    }

    public void sendSignal() {
        System.out.println(name + "подают сигнал");
    }

    public void recieveSupplies(ArrayList<Resource> supplies) {
        boat.setCapacity(supplies);
    }

    public void sail(Time time) {
        System.out.println("Они отчаляли на " + boat.toString() + " " + time.toString());
    }

    public Boat getBoat() {
        return boat;
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null) return false;
        if (getClass() != ob.getClass()) return false;
        Envoys o = (Envoys) ob;
        return (this.name.equals(o.name) && this.boat.equals(o.boat));

    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return 31 + name.hashCode() + boat.hashCode();
    }
}
