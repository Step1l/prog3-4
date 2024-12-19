import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Robinson implements GiftRes{
    private ArrayList<Resource> resources;
    private Mood mood;
    private String familar_signal;
    private String name;
    private int YarsInExile;
    private int count_attempt;

    public Robinson(String name,Mood mood,int YearsInExile){
        this.name=name;
        this.mood = mood;
        this.YarsInExile = YearsInExile;
        count_attempt=0;

    }
    @Override
    public void prepareResources(Resource resource, int count){
        for (int i=0; i< count;i++){
            resources.add(resource);
        }
    }
    @Override
    public ArrayList<Resource> provideResources (int enough_count){
        if (resources.size()< enough_count){
                int i=0;
            // Исключение выбрасываем, или засчитываем, как неудачную попытку
        }
        ArrayList<Resource> provided = new ArrayList<Resource>();
        for (int i=0; i< count; i++){
            provided.add(resources.remove(0));
        }
        return provided;
        System.out.println("Я снабдил их ресурсами");
    }

    public void negotitateWithEnvoys(Envoys envoys, String signal){
        this.familar_signal = signal;
        envoys.getBoat.setSignal(signal);
        System.out.println("Я условился с"+ envoys.name +"что на обратном пути они подадут сигнал, по которому я мог бы издали признать их лодку");

    }
    public void wishGoodLuck(Envous envoys) {
        System.out.println("Я пожелал"+ envoys.name +"удачи");
    }
    public boolean recognizeBoat(Boat boat){
        if (boat.use() == this.familar_signal){
            return true;
        }
        return false;
    }

    public void checkCalendar(Calendar calendar){
        System.out.println("Я проверил календарь");
        calendar.printEvents();
    }
    public Mood getMood(){
        return this.moode;
    }
    public void setMood(Mood mood){
        this.mood = mood;
    }
    public void printAttempt(){
        System.out.println("Это была моя"+ this.count_attempt+ "попытка");
    }
    // public randomAttempt
    @Override
    public boolean equals(Object ob){
        if (getClass() != ob.getClass())
        if (this == ob) return true;
        Robinson o = (Robinson) ob;
        if (this.name==o.name && this.mood == o.mood && this.resources.equals(o.resources) && this.familar_signal == o.familar_signal && this.YarsInExile == o.YarsInExile && this.count_attempt == o.count_attempt){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return name;
    }
    //hashcode
}
