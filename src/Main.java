public class Main {
    public static void main(String[] args){
        Robinson rob = new Robinson("Робинзон",Mood.HAPPY,37);
        Envoys en =new Envoys("отлываюзие",new Boat("лодка"));
        Calendar cal = new Calendar("Калнедарь");
        cal.addEvent(new CalendarEvent("01.02.2022","День отплытия"));
        cal.addEvent(new CalendarEvent("01.222.31","День рождения"));
        cal.addEvent(new CalendarEvent("lol","ass"));
        rob.prepareResources(new Resource("ящик изюма", Food.RAISIN),0);
        rob.prepareResources(new Resource("ящик хлеба",Food.BREAD),0);
        try {
            rob.makeRandomAttempt(cal,en,"01.02.2022");
        }catch(NotEnoughException e){
            System.out.println(e.getMessage());
            System.out.println("Неудачная попытка(");
        }catch (EmptyEventException e){
            System.out.println("В календаре не оказалось дня отплытия, робинзон запутался");
            System.out.println("Неудачная попытка(");
        }

    }
}
