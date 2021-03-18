package login;
import database.IAuthenticationOperations;
import userinterface.IInputOutputHandler;
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
        user_password = encryption.encryptPassword(user_password);
        if(authenticationOperations.authenticateUser(employeeID, user_password))
        {
            inputOutputHandler.displayMethod("Login Successful");
            result = true;
            return result;
        }
        inputOutputHandler.displayMethod("Error: Login unsuccessful. Please use correct username and password to try again.");
        result = false;
        return result;
    }
}
