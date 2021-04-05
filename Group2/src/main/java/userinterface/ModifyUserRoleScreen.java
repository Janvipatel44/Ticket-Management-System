package userinterface;

import roles.interfaces.IModifyUserRole;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class ModifyUserRoleScreen implements IModifyUserRoleScreen {
	
	public final String SUCCESSFUL_USER_ROLE_UPDATE = "User role is updated successfully.";
	public final String UNSUCCESSFUL_USER_ROLE_UPDATE = "User role is not updated successfully. Please contact admin.";

	private IInputOutputHandler inputOutputHandler;
	private IModifyUserRole modifyUserRole;

	public ModifyUserRoleScreen(IInputOutputHandler inputOutputHandler, IModifyUserRole modifyUserRole) {
		this.inputOutputHandler = inputOutputHandler;
		this.modifyUserRole = modifyUserRole; 
	}

	public void displayModifyUserRoleScreen(String empId, String userType) {

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

		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IBackToHomePageScreen backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
		backToHomePageScreen.displayGoBackToHomePageOption(empId, userType);
	}

}
