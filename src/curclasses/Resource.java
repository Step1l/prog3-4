package curclasses;
import enums.Food;
public class Resource {
    private Food type;
    private String name;
    public Resource(String name, Food type){
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object ob){
        if (this == ob) return true;
        if (ob == null) return false;
        if (getClass() != ob.getClass()) return false;
        Resource o = (Resource) ob;
        return (this.type == o.type && name.equals(o.name));

    }
    @Override
    public int hashCode(){
        return 31+type.hashCode();
    }
}
