package userinterface;
public class LoginScreen implements ILoginScreen
{
    private final IInputOutputHandler inputOutputHandler;
    LoginScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }
    public void displayLoginScreen()
    {
        inputOutputHandler.displayMethod("Welcome to ServiceNow Mock application\n\n Press 1 to login\n Press 2 to register as a new user");
    }
}
