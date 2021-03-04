package login;
import com.group2.userinterface.IInputOutputHandler;
public class Authentication implements IAuthentication
{
    private final IAuthenticationOperations authenticationOperations;
    private final IEncryption encryption;
    private final IInputOutputHandler inputOutputHandler;

    public Authentication(IAuthenticationOperations authenticationOperations, IEncryption encryption, IInputOutputHandler inputOutputHandler)
    {
        this.authenticationOperations = authenticationOperations;
        this.encryption = encryption;
        this.inputOutputHandler = inputOutputHandler;
    }
    public boolean authenticateUser(String employeeID, String user_password)
    {
        boolean result;
        final String failedMessage = "Error: Unable to fetch password from database. Please try again.";
        final String userNotFound = "Error: User does not exist.";
        final String successfulMessage = "Login Successful";
        String actual_password;
        
        user_password = encryption.encryptPassword(user_password);
        actual_password = authenticationOperations.getPassword(employeeID);
        if(actual_password.equals(failedMessage))
        {
        	inputOutputHandler.displayMethod(failedMessage);
        	 result = false;
             return result;
        }
        else if(actual_password.equals(userNotFound))
        {
        	inputOutputHandler.displayMethod(userNotFound);
        	 result = false;
             return result;
        }
        else
        {
            inputOutputHandler.displayMethod(successfulMessage);
            result = true;
            return result;
        }
    }
}
