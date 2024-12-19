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

    public CalendarEvent findByDate(String date){
         for(int i=0; i<events.size();i++){
             if (date == events.get(i).date()){
                 return events.get(i);
             }
         }
         //exception
    }

    public void comingDay(String date){
            System.out.println("Наступил" +findByDate(date).eventDescription());
    }

}
