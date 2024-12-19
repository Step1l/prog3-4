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
        System.out.println("Они отчаляли в " + time.toString());
    }

    @Override
    public boolean equals(Object ob){
        if (getClass() != ob.getClass()) return false;
        if (this == ob) return true;
        Envoys o = (Envoys) ob;
        if (this.name == o.name && this.boat.equals(o.boat)) return true;
        return false
    }

    @Override
    public String toString(){
        return  name;
    }

    //hashcode
}
