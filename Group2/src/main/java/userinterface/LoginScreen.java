package userinterface;
public class LoginScreen implements ILoginScreen
{
    IInputOutputHandler inputOutputHandler;

    public LoginScreen(InputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayLoginScreen()
    {
        String employeeID;
        String password;

        inputOutputHandler.displayMethod("Enter employeeID:\n");
        employeeID = inputOutputHandler.input();

        inputOutputHandler.displayMethod("Enter password:\n");
        password = inputOutputHandler.input();


    }
}
