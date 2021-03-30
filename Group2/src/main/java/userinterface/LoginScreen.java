package userinterface;
import login.Interfaces.IAuthentication;
import login.Interfaces.IAuthenticationOperations;
import login.abstractFactory.LoginFactory;
import login.abstractFactory.LoginFactoryImplementation;
import userinterface.abstractFactory.UserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactoryImplementation;
public class LoginScreen implements ILoginScreen
{
    IInputOutputHandler inputOutputHandler;
    UserInterfaceFactory userInterfaceFactory = new UserInterfaceFactoryImplementation();
    LoginFactory loginFactory = new LoginFactoryImplementation();

    public LoginScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayLoginScreen()
    {
        IServiceNowWelcomeScreen serviceNowWelcomeScreen = userInterfaceFactory.getServiceNowWelcomeScreen(inputOutputHandler);;
        IAuthenticationOperations authenticationOperations = loginFactory.getAuthenticationOperations();;
        IAuthentication authentication = loginFactory.getAuthentication(authenticationOperations);;
        String employeeID;
        String password;

        inputOutputHandler.displayMethod("Enter employeeID:\n");
        employeeID = inputOutputHandler.input();

        inputOutputHandler.displayMethod("Enter password:\n");
        password = inputOutputHandler.input();

        if(authentication.authenticateUser(employeeID, password))
        {

        }
        else
        {
            serviceNowWelcomeScreen.displayLoginScreen();
        }
    }
}