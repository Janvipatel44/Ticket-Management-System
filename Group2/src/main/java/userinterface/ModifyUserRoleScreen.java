package userinterface;

import login.Interfaces.IParameterizedUser;
import roles.interfaces.IModifyUserRole;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class ModifyUserRoleScreen implements IModifyUserRoleScreen {
	
	public final String SUCCESSFUL_USER_ROLE_UPDATE = "User role is updated successfully.";
	public final String UNSUCCESSFUL_USER_ROLE_UPDATE = "User role is not updated successfully. Please contact admin.";

	private IInputOutputHandler inputOutputHandler;
	private IModifyUserRole modifyUserRole;
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;

	public ModifyUserRoleScreen(IInputOutputHandler inputOutputHandler, IModifyUserRole modifyUserRole) {
		this.inputOutputHandler = inputOutputHandler;
		this.modifyUserRole = modifyUserRole; 
	}

	public void displayModifyUserRoleScreen(IParameterizedUser user) {

		try {
			String inputEmpId = inputOutputHandler.input();
			String inputUserType = inputOutputHandler.input();
			boolean isUserRoleModified = modifyUserRole.modifyUserRole(inputEmpId, inputUserType);
			if (isUserRoleModified) {
				inputOutputHandler.displayMethod(SUCCESSFUL_USER_ROLE_UPDATE);
			} else {
				inputOutputHandler.displayMethod(UNSUCCESSFUL_USER_ROLE_UPDATE);
			}

		} catch (Exception e) {
			inputOutputHandler.displayMethod(UNSUCCESSFUL_USER_ROLE_UPDATE);
		}

		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);
	}

}
