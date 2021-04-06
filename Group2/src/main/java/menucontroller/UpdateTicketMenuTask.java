package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.IupdateTicketScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class UpdateTicketMenuTask implements IMenuTask
{

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IupdateTicketScreen updateticketscreen = userInterfaceFactory.getUpdateTicketScreen(inputOutputHandler);
		updateticketscreen.updateticketscreen(user);
		
	}

}
