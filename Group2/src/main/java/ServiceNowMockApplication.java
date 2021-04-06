import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.*;
public class ServiceNowMockApplication
{
    public static void main(String[] args)
    {
        IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
        IInputOutputHandler inputOutputHandler = userInterfaceFactory.getInputOutputHandler();
        userInterfaceFactory.getServiceNowWelcomeScreen(inputOutputHandler);
    }
}
