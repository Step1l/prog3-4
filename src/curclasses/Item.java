package curclasses;

public abstract class Item {
    private String name;

    public Item(String name){
        this.name=name;
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public boolean equals(Object ob){
        if (this == ob) return true;
        if (ob==null) return false;
        if (getClass() != ob.getClass()) return false;

        Item o = (Item) ob;
        return Objects.equals(name,o.name);

    }

    @Override
    public int hashCode(){
        return 31 + name.hashCode();
    }
    abstract Object use();
}
