package menucontroller;
import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.*;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;
import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;

public class CreateTicketMenuTask implements IMenuTask 
{
	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) 
	{	
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IGenerateTicketScreen generateTicket = userInterfaceFactory.getGenerateTicketScreen(inputOutputHandler);
		generateTicket.displayTicketGenerationScreen();
	}
}