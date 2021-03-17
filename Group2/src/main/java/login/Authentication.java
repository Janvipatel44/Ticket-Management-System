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
        final String failedMessage = "Error: User does not exist. Please try with correct username.";
        final String successfulMessage = "Login Successful";
        String actual_password;
        
        user_password = encryption.encryptPassword(user_password);
        actual_password = authenticationOperations.getPassword(employeeID);
        if(actual_password.equals(user_password))
        {
            inputOutputHandler.displayMethod(successfulMessage);
            result = true;
            return result;
        }
        else
        {
            inputOutputHandler.displayMethod(failedMessage);
            result = false;
            return result;
        }
    }
}
