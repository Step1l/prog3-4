package exceptions;

public class EmptyEventException extends Exception{
    public EmptyEventException(){};
    public EmptyEventException(String message){
        super(message);
    }

}
