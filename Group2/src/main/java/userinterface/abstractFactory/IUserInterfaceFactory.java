package userinterface.abstractFactory;
import userinterface.IBackToHomePageScreen;
import userinterface.ICustomerAnalysisScreen;
import userinterface.IEmployeeMilestoneScreen;
import userinterface.IForgotPasswordScreen;
import userinterface.IHomePageScreen;
import userinterface.IInputOutputHandler;
import userinterface.ILoginScreen;
import userinterface.IManagerTeamTrackingScreen;
import userinterface.IModifyUserRoleScreen;
import userinterface.IRatingScreen;
import userinterface.IRegistrationScreen;
import userinterface.IServiceNowWelcomeScreen;
<<<<<<< HEAD
import userinterface.IdeleteTicketScreen;
=======
import userinterface.ITwitterPostScreen;
import userinterface.IupdateTicketScreen;
import userinterface.IcommentOnTicketScreen;
>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
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
<<<<<<< HEAD
    public IdeleteTicketScreen getdeleteTicketScreen(IInputOutputHandler inputOutputHandler);
=======
    public ITwitterPostScreen getTwitterPostScreen(IInputOutputHandler inputOutputHandler);
    public IupdateTicketScreen getUpdateTicketScreen(IInputOutputHandler inputOutputHandler);
    public IcommentOnTicketScreen getCommentOnTicketScreen(IInputOutputHandler inputOutputHandler);

>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
}
