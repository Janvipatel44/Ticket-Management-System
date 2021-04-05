package userinterface.abstractFactory;
import customerAnalysis.Interfaces.ICustomerAnalysis;
import userinterface.*;
public interface IUserInterfaceFactory
{
    public IServiceNowWelcomeScreen getServiceNowWelcomeScreen(IInputOutputHandler inputOutputHandler);
    public IInputOutputHandler getInputOutputHandler();
    public ILoginScreen getLoginScreen(IInputOutputHandler inputOutputHandler);
    public IRegistrationScreen getRegistrationScreen(IInputOutputHandler inputOutputHandler);
    public IForgotPasswordScreen getForgotPasswordScreen(IInputOutputHandler inputOutputHandler);
    public IBackToHomePageScreen getBackToHomePageScreen(IInputOutputHandler inputOutputHandler);
    public IModifyUserRoleScreen getModifyUserRoleScreen(IInputOutputHandler inputOutputHandler);
    public IManagerTeamTrackingScreen getmangerTeamTrackingScreen(IInputOutputHandler inputOutputHandler);
    public IHomePageScreen getHomePageScreen(IInputOutputHandler inputOutputHandler);
    public IRatingScreen getRatingScreen(IInputOutputHandler inputOutputHandler);
    public ICustomerAnalysisScreen getCustomerAnalysisScreen(IInputOutputHandler inputOutputHandler);
    public IEmployeeMilestoneScreen getEmployeeMilestoneScreen(IInputOutputHandler inputOutputHandler);
}
