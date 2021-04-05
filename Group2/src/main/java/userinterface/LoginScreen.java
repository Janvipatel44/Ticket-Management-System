package userinterface;
import login.Interfaces.*;
import login.abstractfactory.*;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;
public class LoginScreen implements ILoginScreen
{
    IInputOutputHandler inputOutputHandler;
    IUserInterfaceFactory userInterfaceFactory = new UserInterfaceFactory();
    ILoginFactory loginFactory = LoginFactory.instance();

    public LoginScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayLoginScreen()
    {
        IServiceNowWelcomeScreen serviceNowWelcomeScreen = userInterfaceFactory.getServiceNowWelcomeScreen(inputOutputHandler);;
        IPersistenceAuthenticationOperations authenticationOperations = loginFactory.getAuthenticationOperations();;
        IAuthentication authentication = loginFactory.getAuthentication(authenticationOperations);
        IParameterizedUser parameterizedUser;
        String employeeID="";
        String password;

        inputOutputHandler.displayMethod("Enter employeeID:\n");
        employeeID = inputOutputHandler.input();

        inputOutputHandler.displayMethod("Enter password:\n");
        password = inputOutputHandler.input();

        if(authentication.authenticateUser(employeeID, password))
        {
            parameterizedUser = authentication.getUserDetails(employeeID);
        }
        else
        {
            serviceNowWelcomeScreen.displayLoginScreen();
        }
    }
}