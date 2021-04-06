package userinterface.abstractFactory;

import userinterface.IBackToHomePageScreen;
import userinterface.ICustomerAnalysisScreen;
import userinterface.IEmployeeMilestoneScreen;
import userinterface.IEmployeePerformanceScreen;
import userinterface.IForgotPasswordScreen;
import userinterface.IGenerateTicketScreen;
import userinterface.IHomePageScreen;
import userinterface.IInputOutputHandler;
import userinterface.ILoginScreen;
import userinterface.IManagerTeamTrackingScreen;
import userinterface.IModifyUserRoleScreen;
import userinterface.IRatingScreen;
import userinterface.IRegistrationScreen;
import userinterface.IServiceNowWelcomeScreen;
import userinterface.ITwitterPostScreen;
import userinterface.IcommentOnTicketScreen;
import userinterface.IdeleteTicketScreen;
import userinterface.IsearchTicketScreen;
import userinterface.IsortTciketScreen;
import userinterface.IupdateTicketScreen;

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
    public IGenerateTicketScreen getGenerateTicketScreen(IInputOutputHandler inputOutputHandler);
    public IEmployeePerformanceScreen getEmployeePerformanceScreen(IInputOutputHandler inputOutputHandler);
    public IsortTciketScreen getsortTicketScreen(IInputOutputHandler inputOutputHandler);
    public IsearchTicketScreen getsearchTicketScreen(IInputOutputHandler inputOutputHandler);
    public IdeleteTicketScreen getdeleteTicketScreen(IInputOutputHandler inputOutputHandler);
    public ITwitterPostScreen getTwitterPostScreen(IInputOutputHandler inputOutputHandler);
    public IupdateTicketScreen getUpdateTicketScreen(IInputOutputHandler inputOutputHandler);
    public IcommentOnTicketScreen getCommentOnTicketScreen(IInputOutputHandler inputOutputHandler);

}
