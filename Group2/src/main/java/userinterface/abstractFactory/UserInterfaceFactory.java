package userinterface.abstractFactory;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import managerfeatures.abstractfactory.ManagerFeaturesFactory;
import managerfeatures.interfaces.IManagerTeamTracking;
import roles.abstractfactory.IRoleFactory;
import roles.abstractfactory.RoleFactory;
import roles.interfaces.IMenuItemsByRole;
import roles.interfaces.IModifyUserRole;
import userinterface.BackToHomePageOption;
import userinterface.ForgotPasswordScreen;
import userinterface.HomePageScreen;
import userinterface.IBackToHomePageScreen;
import userinterface.IForgotPasswordScreen;
import userinterface.IHomePageScreen;
import userinterface.IInputOutputHandler;
import userinterface.ILoginScreen;
import userinterface.IManagerTeamTrackingScreen;
import userinterface.IModifyUserRoleScreen;
import userinterface.IRegistrationScreen;
import userinterface.IServiceNowWelcomeScreen;
import userinterface.InputOutputHandler;
import userinterface.LoginScreen;
import userinterface.ManagerTeamTrackingScreen;
import userinterface.ModifyUserRoleScreen;
import userinterface.RegistrationScreen;
import userinterface.ServiceNowWelcomeScreen;

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
    	IRoleFactory roleFactory = RoleFactory.instance();
    	IModifyUserRole modifyUserRole = roleFactory.makeModifyUserRoleObject();
        return new ModifyUserRoleScreen(inputOutputHandler, modifyUserRole);
    }
    
    public IManagerTeamTrackingScreen getmangerTeamTrackingScreen(IInputOutputHandler inputOutputHandler)
    {
    	IManagerFeaturesFactory managerFeaturesFactory = ManagerFeaturesFactory.instance();
    	IManagerTeamTracking managerTeamTracking = managerFeaturesFactory.makeManagerFeaturesFactoryObject();
        return new ManagerTeamTrackingScreen(inputOutputHandler, managerTeamTracking);
    }
    
    public IHomePageScreen getHomePageScreen(IInputOutputHandler inputOutputHandler)
    {
    	IRoleFactory roleFactory = RoleFactory.instance();
    	IMenuItemsByRole menuItemsByRole = roleFactory.makeMenuItemsByRoleObject();
        return new HomePageScreen(menuItemsByRole, inputOutputHandler);
    }
}
