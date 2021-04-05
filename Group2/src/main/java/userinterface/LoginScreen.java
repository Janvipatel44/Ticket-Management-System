package userinterface;
import login.Interfaces.*;
import login.abstractfactory.*;
import menucontroller.CreateTicketMenuTask;
import menucontroller.MenuHandler;
import menucontroller.abstractfactory.IMenuHandlerFactory;
import menucontroller.abstractfactory.MenuHandlerFactory;
import menucontroller.interfaces.IMenuHandler;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;
public class LoginScreen implements ILoginScreen
{
    private final IInputOutputHandler inputOutputHandler;
    private final IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
    private final IMenuHandlerFactory menuHandlerFactory = MenuHandlerFactory.instance();
    private final ILoginFactory loginFactory = LoginFactory.instance();
    private IMenuHandler menuHandler;

    public LoginScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
        this.menuHandler = menuHandlerFactory.makeMenuHandlerObject();
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
            MenuHandler.Menu menuTaskName = MenuHandler.Menu.HOME_PAGE;
            menuHandler.runMenuTask(parameterizedUser);
        }
        else
        {
            serviceNowWelcomeScreen.displayLoginScreen();
        }
    }
}