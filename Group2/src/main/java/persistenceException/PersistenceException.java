package persistenceException;
public class PersistenceException extends RuntimeException {

    String message;

    PersistenceException(String message)
    {
        this.message=message;
    }

    String getString()
    {
        return message;
    }
}
