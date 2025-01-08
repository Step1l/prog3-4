package records;

import enums.DayOfWeek;
import enums.Month;
import enums.Moon;
import enums.Wheather;

public record Time (DayOfWeek day, Month month, Moon moon, Wheather wheather){
    @Override
    public String toString(){
        String[] base = new String[4];
        base[0] = switch (day){
            case DayOfWeek.MONDAY -> "в понедельник";
            case DayOfWeek.TUESDAY -> "во вторник";
            case DayOfWeek.WEDNESDAY -> "в среду";
            case DayOfWeek.THURSDAY -> "в четверг";
            case DayOfWeek.FRIDAY -> "в пятницу";
            case DayOfWeek.SATURDAY -> "в субботу";
            case DayOfWeek.SUNDAY -> "в воскресенье";
            case DayOfWeek.NON -> "";

        };
        base[1] = switch (month){
            case Month.JANUARY -> "в январе";
            case Month.FEBRUARY -> "в феварле";
            case Month.MARCH -> "в марте";
            case Month.APRIL -> "в апреле";
            case Month.MAY -> "в мае";
            case Month.JUNE -> "в июне";
            case Month.JULY -> "в июле";
            case Month.AUGUST -> "в августе";
            case Month.SEPTEMBER -> "в сентябре";
            case Month.OCTOBER -> "в октябре";
            case Month.NOVEMBER -> "в ноябре";
            case Month.DECEMBER -> "в декабре";
            case Month.NON -> "";
        };

        base[2] = switch (moon){
            case Moon.FULLMOON -> "в полнолуние";
            case Moon.NEWMOON -> "в новолуние";
            case Moon.NON -> "";
        };
        base[3] = switch (wheather){
            case Wheather.FOGGY  -> "в туманную погоду";
            case Wheather.RAINY -> "в дождь";
            case Wheather.SNOWY -> "в снег";
            case Wheather.STORMY -> "в шторм";
            case Wheather.SUNNY -> "в ясную погоду";
            case Wheather.WINDY -> "в ветренную погоду";
            case Wheather.NON -> "";
        };

        return base[0] +' ' +base[1] +' ' +base[2]+' '+base[3];
    }
}