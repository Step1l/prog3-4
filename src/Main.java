public class Main {

    public static void makeStory(String nameRobinzone, String nameEnvoys,String nameBoat,int yearsInExile,Mood startMood,Calendar cal){
        Robinson rob = new Robinson(nameRobinzone,startMood,yearsInExile);
        rob.prepareResources(new Resource("ящик хлеба",Food.BREAD),(int)(Math.random()*60));
        rob.prepareResources(new Resource("ящик изюма",Food.RAISIN),(int)(Math.random()*60));
        Envoys env = new Envoys(nameEnvoys,new Boat(nameBoat));
        int randDay = (int)(Math.random()*26 +1);
        int randMonth = (int)(Math.random()*11 +1);
        int randYear = (int)(Math.random()*2024);
        cal.addEvent(new CalendarEvent(randDay +"." + randMonth +"." + randYear,"день отплытия" ));
        boolean goodEnd = false;
        mainloop:
        while (rob.getCountResources()>=20){
            boolean flag =true;
            try {
                rob.makeRandomAttempt(cal,env,randDay +"." + randMonth +"." + randYear);
            } catch (NotEnoughException e) {
                System.out.println(e.getMessage());
                System.out.println("Неудачная попытка");
                flag =false ;
            }catch (EmptyEventException e){
                System.out.println("Робинзон не обнаружил в своем календаре дня отплытия");
                System.out.println("Неудачная попытка");
                flag =false ;
            }catch(RandomLuckException e){
                System.out.println(e.getMessage());
                System.out.println("Неудачная попытка");
                flag =false;
            }
            if (flag) {
                System.out.println("Успешно!");
                goodEnd = true;
                break;}
            else{
                Mood newMood = switch (rob.getMood()){
                    case Mood.HAPPY -> Mood.HOPEFULL;
                    case Mood.HOPEFULL -> Mood.NEUTRAL;
                    case Mood.NEUTRAL -> Mood.SAD;
                    case Mood.SAD -> Mood.SAD;
                };
                rob.setMood(newMood);
                randYear++;
                cal.addEvent(new CalendarEvent(randDay +"." + randMonth +"." + randYear,"день отплытия" ));
            }
            try {
                Thread.sleep(2000);
                System.out.println();
            } catch (InterruptedException e) {}
        }
        if (!goodEnd){
            System.out.println("У " +nameRobinzone + " закончились ресурсы, он умрет от голода)");
        }

    }


    public  static void main(String[] args){

        Calendar c = new Calendar("календарь");
        c.addEvent(new CalendarEvent("01.01.1939","Размандоваска"));
        makeStory("Робинзон","Дауны","Корыто",88, Mood.HOPEFULL,c);
    }
}
