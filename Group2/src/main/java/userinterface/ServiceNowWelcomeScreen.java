package userinterface;
public class ServiceNowWelcomeScreen implements IServiceNowWelcomeScreen
{
    private final IInputOutputHandler inputOutputHandler;
    ServiceNowWelcomeScreen(IInputOutputHandler inputOutputHandler)
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

        }
    }
}
