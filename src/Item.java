public abstract class Item {
    private String name;

    public Item(String name){
        this.name=name;
    }
    @Override
    public String toString(){
        return name;
    }
    abstract Object use();
}
