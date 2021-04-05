package userinterface;
import userinterface.abstractFactory.*;
public class ServiceNowWelcomeScreen implements IServiceNowWelcomeScreen
{
    IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
    private final IInputOutputHandler inputOutputHandler;

    public ServiceNowWelcomeScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayLoginScreen()
    {
        int choice;
        inputOutputHandler.displayMethod("Welcome to ServiceNow Mock application\n\n Press 1 to login\n Press 2 to register as a new user\n Press 3 if you forgot password");
        choice = inputOutputHandler.inputInt();
        if(choice == 1)
        {
            ILoginScreen loginScreen = userInterfaceFactory.getLoginScreen(inputOutputHandler);
        }
        else if(choice == 2)
        {
            IRegistrationScreen registrationScreen = userInterfaceFactory.getRegistrationScreen(inputOutputHandler);
        }
        else if(choice == 3)
        {
            IForgotPasswordScreen forgotPasswordScreen = userInterfaceFactory.getForgotPasswordScreen(inputOutputHandler);
        }
    }
}
