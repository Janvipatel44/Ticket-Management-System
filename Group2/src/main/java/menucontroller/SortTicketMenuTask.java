package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.IsortTciketScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class SortTicketMenuTask implements IMenuTask
{

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IsortTciketScreen getsortticketscreen = userInterfaceFactory.getsortTicketScreen(inputOutputHandler);
		//getsortticketscreen.displayRegistrationScreen(user);
		
		
	}

}
