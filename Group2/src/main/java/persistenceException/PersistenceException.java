package persistenceException;
public class PersistenceException extends RuntimeException {

    String message;

    public PersistenceException(String message)
    {
        this.message=message;
    }

    public String getString()
    {
        return message;
    }
}
