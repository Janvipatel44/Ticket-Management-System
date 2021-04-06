package userinterface.abstractFactory;
import userinterface.BackToHomePageOption;
import userinterface.CustomerAnalysisScreen;
import userinterface.EmployeeMilestoneScreen;
import userinterface.ForgotPasswordScreen;
import userinterface.HomePageScreen;
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
import userinterface.InputOutputHandler;
import userinterface.IupdateTicketScreen;
import userinterface.IcommentOnTicketScreen;
>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
import userinterface.InputOutputHandler;
import userinterface.LoginScreen;
import userinterface.ManagerTeamTrackingScreen;
import userinterface.ModifyUserRoleScreen;
import userinterface.RatingScreen;
import userinterface.RegistrationScreen;
import userinterface.ServiceNowWelcomeScreen;
<<<<<<< HEAD
import userinterface.deleteTicketScreen;
=======
import userinterface.TwitterPostScreen;
import userinterface.updateTicketScreen;
import userinterface.commentOnTicketScreen;
>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
public class UserInterfaceFactory implements IUserInterfaceFactory
{
	private static IUserInterfaceFactory uniqueInstance = null;
	
	private UserInterfaceFactory() {
	}
	
	public static IUserInterfaceFactory instance() {
		if(null == uniqueInstance) {
			uniqueInstance = new UserInterfaceFactory();
		}
		return uniqueInstance;
	}
	
    public IServiceNowWelcomeScreen getServiceNowWelcomeScreen(IInputOutputHandler inputOutputHandler)
    {
        return new ServiceNowWelcomeScreen(inputOutputHandler);
    }

    public IInputOutputHandler getInputOutputHandler()
    {
        return new InputOutputHandler();
    }

    public ILoginScreen getLoginScreen(IInputOutputHandler inputOutputHandler)
    {
        return new LoginScreen(inputOutputHandler);
    }

    public IRegistrationScreen getRegistrationScreen(IInputOutputHandler inputOutputHandler)
    {
        return new RegistrationScreen(inputOutputHandler);
    }

    public IForgotPasswordScreen getForgotPasswordScreen(IInputOutputHandler inputOutputHandler)
    {
        return new ForgotPasswordScreen(inputOutputHandler);
    }
    
    public IBackToHomePageScreen getBackToHomePageScreen(IInputOutputHandler inputOutputHandler)
    {
    	return new BackToHomePageOption(inputOutputHandler);
    }
    
    public IModifyUserRoleScreen getModifyUserRoleScreen(IInputOutputHandler inputOutputHandler)
    {
        return new ModifyUserRoleScreen(inputOutputHandler);
    }
    
    public IManagerTeamTrackingScreen getmangerTeamTrackingScreen(IInputOutputHandler inputOutputHandler)
    {
        return new ManagerTeamTrackingScreen(inputOutputHandler);
    }
    
    public IHomePageScreen getHomePageScreen(IInputOutputHandler inputOutputHandler)
    {
        return new HomePageScreen(inputOutputHandler);
    }

    public IRatingScreen getRatingScreen(IInputOutputHandler inputOutputHandler)
    {
        return new RatingScreen(inputOutputHandler);
    }

    public ICustomerAnalysisScreen getCustomerAnalysisScreen(IInputOutputHandler inputOutputHandler)
    {
        return new CustomerAnalysisScreen(inputOutputHandler);
    }

    public IEmployeeMilestoneScreen getEmployeeMilestoneScreen(IInputOutputHandler inputOutputHandler)
    {
        return new EmployeeMilestoneScreen(inputOutputHandler);
    }
<<<<<<< HEAD
    public IdeleteTicketScreen getdeleteTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        return new deleteTicketScreen(inputOutputHandler);
    }
=======
    
    public ITwitterPostScreen getTwitterPostScreen(IInputOutputHandler inputOutputHandler)
    {
        return new TwitterPostScreen(inputOutputHandler);
    }
    
    public IupdateTicketScreen getUpdateTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        return new updateTicketScreen(inputOutputHandler);
    }

    public IcommentOnTicketScreen getCommentOnTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        return new commentOnTicketScreen(inputOutputHandler);
    }

>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
}
