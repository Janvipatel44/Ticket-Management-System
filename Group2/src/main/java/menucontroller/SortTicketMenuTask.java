package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.IStoreTicketData;
import userinterface.IInputOutputHandler;
import userinterface.ISortTciketScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class SortTicketMenuTask implements IMenuTask {
	
	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IReuseableClasssFactory reuseablefactory=ReuseableClasssFactory.instance();
		IStoreTicketData storeticketdata=reuseablefactory.storeTicketData();
		ISortTciketScreen sortTicketscreen = userInterfaceFactory.getsortTicketScreen(inputOutputHandler,storeticketdata);
		sortTicketscreen.sortticketscreen(user);
	}
}
