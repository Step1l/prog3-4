import java.util.ArrayList;

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
        resources = new ArrayList<Resource>();

    }
    @Override
    public void prepareResources(Resource resource, int count){
        for (int i=0; i< count;i++){
            resources.add(resource);
        }
    }
    @Override
    public ArrayList<Resource> provideResources (int enough_count) throws NotEnoughException {
        if (resources.size()< enough_count){
                throw new NotEnoughException("Ресурсов у меня не хватило");
        }
        ArrayList<Resource> provided = new ArrayList<Resource>();
        for (int i=0; i< enough_count; i++){
            provided.add(resources.remove(0));
        }
        System.out.println("Я снабдил их запасами хлеба и изюма");
        return provided;
    }

    public void negotitateWithEnvoys(Envoys envoys, String signal){
        this.familar_signal = signal;
        envoys.getBoat().setSignal(signal);
        System.out.println("Я условился с"+ envoys.toString() +"что на обратном пути они подадут сигнал, по которому я мог бы издали признать их лодку");

    }
    public void wishGoodLuck(Envoys envoys) {
        System.out.println("Я пожелал"+ envoys.toString() +"удачи");
    }
    public boolean recognizeBoat(Boat boat){
        if (boat.use() == this.familar_signal){
            return true;
        }
        return false;
    }

    public void checkCalendar(Calendar calendar){
        System.out.println("Я проверил календарь");
        ArrayList<CalendarEvent> c = calendar.use();
        for (int i=0; i<c.size();i++){
            System.out.println(c.get(i).toString());
        }
    }
    public Mood getMood(){
        return this.mood;
    }
    public void setMood(Mood mood){
        this.mood = mood;
    }
    public void printAttempt(){
        System.out.println("Это была моя"+ (this.count_attempt)+ "сербезная попытка за " + YarsInExile + "лет");
    }
    // public randomAttempt



    public void makeRandomAttempt(Calendar calendar, Envoys envoys, String daytosail)throws NotEnoughException,EmptyEventException{
        count_attempt++;
        printAttempt();
        provideResources(26);
        calendar.comingDay(daytosail);
        negotitateWithEnvoys(envoys,"Signal is" + Math.random()*100);
        wishGoodLuck(envoys);
        envoys.sail(new Time(DayOfWeek.MONDAY,Month.DECEMBER,Moon.FULLMOON,Wheather.RAINY));
        checkCalendar(calendar);
    }




    @Override
    public boolean equals(Object ob){
        if (getClass() != ob.getClass()|| hashCode()!= ob.hashCode()) return false;
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
    @Override
    public int hashCode(){
        return 31 + mood.hashCode() +familar_signal.hashCode()+ name.hashCode()+YarsInExile +count_attempt;
    }
}
