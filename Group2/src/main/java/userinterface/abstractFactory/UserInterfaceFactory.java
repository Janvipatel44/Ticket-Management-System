package userinterface.abstractFactory;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import managerfeatures.abstractfactory.ManagerFeaturesFactory;
import managerfeatures.interfaces.IManagerTeamTracking;
import roles.abstractfactory.IRoleFactory;
import roles.abstractfactory.RoleFactory;
import roles.interfaces.IMenuItemsByRole;
import roles.interfaces.IModifyUserRole;
import userinterface.*;
public class UserInterfaceFactory implements IUserInterfaceFactory
{
	private static IUserInterfaceFactory uniqueInstance = null;
	
	public UserInterfaceFactory() {
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
    
    public IGenerateTicketScreen getGenerateTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        return new GenerateTicketScreen(inputOutputHandler);

    }

}
