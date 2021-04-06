package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.IdeleteTicketScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class DeleteTicketMenuTask implements IMenuTask
{

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) 
	{
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IdeleteTicketScreen deleteticketscreen = userInterfaceFactory.getdeleteTicketScreen(inputOutputHandler);
		//deleteticketscreen.displayRegistrationScreen(user);
		
	}

}
