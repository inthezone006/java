import java.io.Serializable;

public class WrongRideException extends Exception{
    public WrongRideException(String message){
        super(message);
    }
}
