package userinterface;
import login.Interfaces.IForgotPassword;
import login.Interfaces.IPersistenceForgotPasswordOperations;
import login.abstractFactory.*;
import mailservice.Gmail;
import mailservice.IMail;
import userinterface.abstractFactory.*;
public class ForgotPasswordScreen implements IForgotPasswordScreen
{
    IInputOutputHandler inputOutputHandler;
    LoginFactory loginFactory = new LoginFactoryImplementation();
    UserInterfaceFactory userInterfaceFactory = new UserInterfaceFactoryImplementation();

    public ForgotPasswordScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void getForgotPasswordScreen()
    {
        IServiceNowWelcomeScreen serviceNowWelcomeScreen;
        IMail mail = new Gmail();
        IPersistenceForgotPasswordOperations persistenceForgotPasswordOperations = loginFactory.getPersistenceForgotPasswordOperations();
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

            serviceNowWelcomeScreen = userInterfaceFactory.getServiceNowWelcomeScreen(inputOutputHandler);
            serviceNowWelcomeScreen.displayLoginScreen();
        }
    }
}