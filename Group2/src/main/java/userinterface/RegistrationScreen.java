package userinterface;
import login.Interfaces.IParameterizedUser;
import login.Interfaces.IPersistenceUserRegistrationOperations;
import login.Interfaces.IRegister;
import login.abstractfactory.*;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;
public class RegistrationScreen implements IRegistrationScreen
{
    IInputOutputHandler inputOutputHandler;
    IUserInterfaceFactory userInterfaceFactory = new UserInterfaceFactory();
    ILoginFactory loginFactory = LoginFactory.instance();

    public RegistrationScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayRegistrationScreen()
    {
        IParameterizedUser user;
        String employeeID;
        String firstName;
        String lastName;
        String password;
        String email;
        String user_type;
        IServiceNowWelcomeScreen serviceNowWelcomeScreen = userInterfaceFactory.getServiceNowWelcomeScreen(inputOutputHandler);;
        IPersistenceUserRegistrationOperations userRegistrationOperations = loginFactory.getPersistenceUserRegistrationOperations();
        IRegister register = loginFactory.getRegister(userRegistrationOperations, inputOutputHandler);

        inputOutputHandler.displayMethod("Enter employeeID.\n");
        employeeID = inputOutputHandler.input();

        inputOutputHandler.displayMethod("Enter first name.\n");
        firstName = inputOutputHandler.input();

        inputOutputHandler.displayMethod("Enter last name.\n");
        lastName = inputOutputHandler.input();

        inputOutputHandler.displayMethod("Enter email.\n");
        email = inputOutputHandler.input();

        inputOutputHandler.displayMethod("Enter employee/user type.\n");
        user_type = inputOutputHandler.input();

        inputOutputHandler.displayMethod("Enter password.\n");
        password = inputOutputHandler.input();

        user = loginFactory.getParameterizedUser(employeeID, firstName, lastName, email, user_type);

        if(register.registerUser(user, password))
        {
            inputOutputHandler.displayMethod("User registered successfully.\n");
        }
        else
        {
            inputOutputHandler.displayMethod("User registration failed.\n");
        }

        serviceNowWelcomeScreen.displayLoginScreen();
    }
}
