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
        if (getClass() != ob.getClass()|| hashCode()!=ob.hashCode()) return false;
        Resource o = (Resource) ob;
        if(this.type == o.type){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return 31+type.hashCode();
    }
}
