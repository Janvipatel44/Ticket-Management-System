package userinterface.abstractFactory;
import userinterface.*;
public abstract class UserInterfaceFactory
{
    public abstract IServiceNowWelcomeScreen getServiceNowWelcomeScreen(IInputOutputHandler inputOutputHandler);
    public abstract IInputOutputHandler getInputOutputHandler();
    public abstract ILoginScreen getLoginScreen(IInputOutputHandler inputOutputHandler);
    public abstract IRegistrationScreen getRegistrationScreen(IInputOutputHandler inputOutputHandler);
    public abstract IForgotPasswordScreen getForgotPasswordScreen(IInputOutputHandler inputOutputHandler);
    public abstract IBackToHomePageScreen getBackToHomePageScreen(IInputOutputHandler inputOutputHandler);
    public abstract IModifyUserRoleScreen getModifyUserRoleScreen(IInputOutputHandler inputOutputHandler);
    public abstract IManagerTeamTrackingScreen getmangerTeamTrackingScreen(IInputOutputHandler inputOutputHandler);
    public abstract IHomePageScreen getHomePageScreen(IInputOutputHandler inputOutputHandler);		
    
}
