package menucontroller.interfaces;

import login.Interfaces.IParameterizedUser;
import menucontroller.MenuHandler.Menu;

public interface IMenuHandler {

	void runMenuTask(Menu menuTaskName, IParameterizedUser user);

}