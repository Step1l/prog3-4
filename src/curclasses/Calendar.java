package curclasses;

import exceptions.EmptyEventException;
import records.CalendarEvent;

import java.util.ArrayList;

public class Calendar extends Item{
     private final ArrayList<CalendarEvent> events;

     public Calendar(String name){
         super(name);
         events = new ArrayList<CalendarEvent>();
     }

     public void addEvent(CalendarEvent event){
         events.add(event);
     }
     @Override
     public ArrayList<CalendarEvent> use(){
         return events;
    }

    public CalendarEvent findByDate(String date) throws EmptyEventException {
         for(int i=0; i<events.size();i++){
             if (date.equals(events.get(i).date())){
                 return events.get(i);
             }
         }
         throw new EmptyEventException("Такого дня нет в календаре");
    }

    public void comingDay(String date) throws EmptyEventException {
            System.out.println("Наступил" + findByDate(date).eventDescription());
    }




    @Override
    public boolean equals(Object ob){
         if (this==ob)return true;
         if (getClass()!= ob.getClass()||hashCode() != ob.hashCode())return false;
         Calendar o = (Calendar)ob;
         if (events.equals(o.use()) && toString().equals(o.toString())) return true;
         return false;
    }


    @Override
    public int hashCode(){
         return 31+events.hashCode() + toString().hashCode();
    }
}
