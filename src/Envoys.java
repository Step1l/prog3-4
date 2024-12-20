import java.util.ArrayList;

public class Envoys {
    private String name;
    private Boat boat;

    public Envoys(String name,Boat boat){
        this.name = name;
        this.boat = boat;
    }

    public void sendSignal(){
        System.out.println(name+"подают сигнал");
    }

    public void recieveSupplies(ArrayList<Resource> supplies){
        boat.setCapacity(supplies);
    }

    public void sail(Time time){
        System.out.println("Они отчаляли на "+ boat.toString()+ " " + time.toString());
    }

    public Boat getBoat() {
        return boat;
    }

    @Override
    public boolean equals(Object ob){
        if (getClass() != ob.getClass() || hashCode()!=ob.hashCode()) return false;
        if (this == ob) return true;
        Envoys o = (Envoys) ob;
        if (this.name == o.name && this.boat.equals(o.boat)) return true;
        return false;
    }

    @Override
    public String toString(){
        return  name;
    }

    @Override
    public int hashCode(){
        return 31 + name.hashCode() + boat.hashCode();
    }
}
