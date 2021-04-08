package userinterface;
import login.Interfaces.IForgotPassword;
import login.Interfaces.IForgotPasswordDao;
import login.abstractfactory.*;
import mailservice.Gmail;
import mailservice.interfaces.IMail;
import userinterface.abstractFactory.*;
import java.io.IOException;
public class ForgotPasswordScreen implements IForgotPasswordScreen
{
    IInputOutputHandler inputOutputHandler;
    ILoginFactory loginFactory = LoginFactory.instance();
    IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();

    public ForgotPasswordScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void getForgotPasswordScreen()
    {
        IServiceNowWelcomeScreen serviceNowWelcomeScreen;
        IMail mail = new Gmail();
        IForgotPasswordDao persistenceForgotPasswordOperations = null;
        serviceNowWelcomeScreen = userInterfaceFactory.getServiceNowWelcomeScreen(inputOutputHandler);

        try
        {
            persistenceForgotPasswordOperations = loginFactory.getPersistenceForgotPasswordOperations();
        }
        catch (IOException e)
        {
            inputOutputHandler.displayMethod("Forgot password process encountered an issue. Please contact system administrator.");
        }

        if(persistenceForgotPasswordOperations == null)
        {
            serviceNowWelcomeScreen.displayLoginScreen();
            return;
        }

        IForgotPassword forgotPassword = loginFactory.getForgotPassword(mail, persistenceForgotPasswordOperations);
        String employeeID;
        String newPassword;
        int otp;

        inputOutputHandler.displayMethod("Enter employeeID:\n");
        employeeID = inputOutputHandler.input();

        if(forgotPassword.sendOTP(employeeID))
        {
            inputOutputHandler.displayMethod("Please enter the OTP that has been sent to registered email address.");
            otp = inputOutputHandler.inputInt();

            inputOutputHandler.displayMethod("Please enter the new password.");
            newPassword = inputOutputHandler.input();

            if(forgotPassword.updatePassword(otp, newPassword))
            {
                inputOutputHandler.displayMethod("Password updated successfully.");
            }
            else
            {
                inputOutputHandler.displayMethod("Invalid OTP. Please try again.");
            }

            serviceNowWelcomeScreen.displayLoginScreen();
        }
    }
}