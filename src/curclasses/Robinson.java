package curclasses;

import enums.*;
import exceptions.EmptyEventException;
import exceptions.NotEnoughException;
import exceptions.RandomLuckException;
import interfaces.GiftRes;
import records.CalendarEvent;

import records.Time;
import java.util.ArrayList;

public class Robinson implements GiftRes {
    private ArrayList<Resource> resources;
    private Mood mood;
    private String familarSignal;
    private String name;
    private int YarsInExile;
    private int countAttempt;

    public Robinson(String name, Mood mood, int YearsInExile){
        this.name=name;
        this.mood = mood;
        this.YarsInExile = YearsInExile;
        countAttempt=0;
        resources = new ArrayList<Resource>();

    }
    @Override
    public void prepareResources(Resource resource, int count){
        for (int i=0; i< count;i++){
            resources.add(resource);
        }
    }
    public int getCountResources(){
        return resources.size();
    }
    @Override
    public ArrayList<Resource> provideResources (int enoughCount) throws NotEnoughException {
        if (resources.size()< enoughCount){
                throw new NotEnoughException("Ресурсов у меня не хватило");
        }
        ArrayList<Resource> provided = new ArrayList<Resource>();
        for (int i=0; i< enoughCount; i++){
            provided.add(resources.remove(0));
        }
        String checkBread = resources.contains(new Resource("ящик хлеба", Food.BREAD))? "хлеба":"";
        String checkRaisim = resources.contains(new Resource("ящик изюма", Food.RAISIN))? "изюма":"";
        System.out.println("Я снабдил их запасами " +checkBread+"," + checkRaisim);
        return provided;
    }

    public void negotitateWithEnvoys(Envoys envoys, String signal){
        this.familarSignal = signal;
        envoys.getBoat().setSignal(signal);
        System.out.println("Я условился с "+ envoys.toString() +" что на обратном пути они подадут сигнал, по которому я мог бы издали признать их " +envoys.getBoat().toString());

    }
    public void wishGoodLuck(Envoys envoys) {
        System.out.println("Я пожелал "+ envoys.toString() +" удачи");
    }
    public boolean recognizeBoat(Boat boat){
        if (boat.use() == this.familarSignal){
            return true;
        }
        return false;
    }
    public void printMood(){
        String par = switch (mood){
            case Mood.HAPPY -> "C какой радостью ";
            case Mood.NEUTRAL -> "";
            case Mood.HOPEFULL -> "С какой надеждой ";
            case Mood.SAD -> "С какой печалью ";
        };
        System.out.println(par + "я снарядил их в дорогу!");}

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
        System.out.println("Это была моя "+ (this.countAttempt)+ " серьезная попытка за " + YarsInExile + " лет");

    }
    // public randomAttempt



    public void makeRandomAttempt(Calendar calendar, Envoys envoys, String daytosail)throws NotEnoughException, EmptyEventException {
        countAttempt++;

        DayOfWeek day = DayOfWeek.values()[(int)(Math.random()*7)];
        Month month = Month.values()[(int)(Math.random()*12)];
        Moon moon = Moon.values()[(int)(Math.random()*2)];
        Wheather wheather = Wheather.values()[(int)(Math.random()*6)];

        double moodCoef = switch(mood){
            case Mood.HAPPY -> 0.1;
            case Mood.NEUTRAL -> 0;
            case Mood.HOPEFULL -> 0.13;
            case Mood.SAD -> -0.2;
        };
        double stormCoef = wheather== Wheather.STORMY ? -0.3 : 0;
        printMood();

        printAttempt();

        YarsInExile++;
        provideResources((int)(Math.random()*100));

        calendar.comingDay(daytosail);

        negotitateWithEnvoys(envoys,"Signal is" + (int)(Math.random()*100));

        wishGoodLuck(envoys);


        envoys.sail(new Time(day,month,moon,wheather));

        if (((Math.random())+0.2 + moodCoef +stormCoef)<=0.5){
            throw new RandomLuckException("В следствии не предвиденных обстоятельств корабль отплывающих разбился");
        }

        System.out.println("Я не был уверен правильно ли отмечены годы в моем календаре");

        checkCalendar(calendar);
    }

    public void makeNoRandomAttempt(Calendar calendar, Envoys envoys, String daytosail,DayOfWeek day,Month month,Moon moon,Wheather wheather)throws NotEnoughException,EmptyEventException{
        countAttempt++;
        printMood();
        printAttempt();
        YarsInExile++;
        envoys.recieveSupplies(provideResources((int)(Math.random()*100)));

        calendar.comingDay(daytosail);

        negotitateWithEnvoys(envoys,"Signal is" + (int)(Math.random()*100));

        wishGoodLuck(envoys);


        envoys.sail(new Time(day,month,moon,wheather));

        System.out.println("Я не был уверен правильно ли отмечены годы в моем календаре");

        checkCalendar(calendar);
    }


    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null) return false;
        if (getClass() != ob.getClass()) return false;
        Robinson o = (Robinson) ob;
        if (this.name==o.name && this.mood == o.mood && this.resources.equals(o.resources) && this.familarSignal == o.familarSignal && this.YarsInExile == o.YarsInExile && this.countAttempt == o.countAttempt){
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
        return 31 + mood.hashCode() +familarSignal.hashCode()+ name.hashCode()+YarsInExile +countAttempt;
    }
}
