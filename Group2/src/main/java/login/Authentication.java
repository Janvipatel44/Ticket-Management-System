package login;
import login.Interfaces.*;
import login.abstractFactory.LoginFactory;
import login.abstractFactory.LoginFactoryImplementation;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;
public class Authentication implements IAuthentication
{
    LoginFactory loginFactory = new LoginFactoryImplementation();
    private final IAuthenticationOperations authenticationOperations;
    private final IEncryption encryption = loginFactory.getEncryption();
    private final IInputOutputHandler inputOutputHandler = new InputOutputHandler();

    public Authentication(IAuthenticationOperations authenticationOperations)
    {
        this.authenticationOperations = authenticationOperations;
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
