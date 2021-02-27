package com.group2.userinterface;

import java.util.List;

import com.group2.roles.IMenuItemsByRole;

import validations.StringValidations;

public class HomePageScreen implements IHomePageScreen {

	private IMenuItemsByRole iMenuItemsByRole;

	public HomePageScreen(IMenuItemsByRole iMenuItemsByRole) {
		super();
		this.iMenuItemsByRole = iMenuItemsByRole;
	}

	public void createUserTaskMenu(String empName, String userType) {

		if (StringValidations.isStringValid(empName) && StringValidations.isStringValid(userType)) {

			InputOutputHandler.displayMethod("Hello " + empName + "\n\nMenu\n");

			List<String> menuItemsList = iMenuItemsByRole.fetchMenuItemsByRole(userType);

			while (true) {
				for (int i = 0; i < menuItemsList.size(); i++) {
					String displayMessage = "" + (i + 1) + ". " + menuItemsList.get(i);
					InputOutputHandler.displayMethod(displayMessage + "\n");
				}

				InputOutputHandler
						.displayMethod("Please select the item from menu (provide corresponding menu item number) : ");
			}
		}

	}

}
