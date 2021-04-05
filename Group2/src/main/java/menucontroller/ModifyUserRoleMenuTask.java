package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.IModifyUserRoleScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class ModifyUserRoleMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfacefactory = UserInterfaceFactory.instance();
		IModifyUserRoleScreen modifyUserRoleScreen = userInterfacefactory.getModifyUserRoleScreen(inputOutputHandler);
		modifyUserRoleScreen.displayModifyUserRoleScreen(user);
	}

}
