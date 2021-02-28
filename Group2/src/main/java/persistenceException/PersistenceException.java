package customException;
public class CustomException extends RuntimeException {

    String message;

    CustomException(String message)
    {
        this.message=message;
    }

    String getString()
    {
        return message;
    }
}
