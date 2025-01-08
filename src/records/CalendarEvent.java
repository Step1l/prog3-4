package records;

public record CalendarEvent(String date, String eventDescription){
    @Override
    public String toString(){
        return date +":" + eventDescription;
    }
}