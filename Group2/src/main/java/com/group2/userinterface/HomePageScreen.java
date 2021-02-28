package com.group2.userinterface;

import java.util.List;

import com.group2.roles.IMenuItemsByRole;

import validations.StringValidations;

public class HomePageScreen implements IHomePageScreen {

	private IMenuItemsByRole iMenuItemsByRole;
	IInputOutputHandler inputOutputHandler;

	public HomePageScreen(IMenuItemsByRole iMenuItemsByRole, IInputOutputHandler inputOutputHandler) {
		this.iMenuItemsByRole = iMenuItemsByRole;
		this.inputOutputHandler = inputOutputHandler;
	}

	public void handleHomePageMenu(String empName, String userType) {

		if (StringValidations.isStringValid(empName) && StringValidations.isStringValid(userType)) {
			inputOutputHandler.displayMethod("Hello " + empName + "\n\nMenu\n");
			displayMenuItems(userType);

			try {
				String menuItemSelection = inputOutputHandler.input();
			} catch (Exception e) {

			}

		}
	}

	private int displayMenuItems(String userType) {
		List<String> menuItemsList = iMenuItemsByRole.fetchMenuItemsByRole(userType);

		int i = 0;

		while (true) {
			for (; i < menuItemsList.size(); i++) {
				String displayMessage = "" + (i + 1) + ". " + menuItemsList.get(i);
				inputOutputHandler.displayMethod(displayMessage + "\n");
			}

			inputOutputHandler
					.displayMethod("Please select the item from menu (provide corresponding menu item number) : ");
		}

		return i;
	}

	private Boolean isValidMenuInput(int minMenuOption, int maxMenuoption, int menuItemSelection) {
		if (menuItemSelection < minMenuOption && menuItemSelection > maxMenuoption) {
			return false;
		}
		return true;
	}

}
