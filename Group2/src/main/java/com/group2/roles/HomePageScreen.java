package com.group2.roles;

import java.util.List;

import com.group2.userinterface.IInputOutputHandler;

import validations.StringValidations;

public class HomePageScreen implements IHomePageScreen {

	private IMenuItemsByRole iMenuItemsByRole;
	IInputOutputHandler inputOutputHandler;

	private final String INVALID_INPUT_MESSAGE = "Please provide valid value for emp name and user type";
	private final String MENU_ITEMS_SELECTION_MESSAGE = "Please select the item from menu (provide corresponding menu item number) : ";
	private final String ERROR_MESSAGE = "You have provided wrong input. Please choose the correct input from menu.";
	private final int MINIMUM_MENU_ITEMS = 1;

	public HomePageScreen(IMenuItemsByRole iMenuItemsByRole, IInputOutputHandler inputOutputHandler) {
		this.iMenuItemsByRole = iMenuItemsByRole;
		this.inputOutputHandler = inputOutputHandler;
	}

	public void handleHomePageMenu(String empName, String userType) throws Exception {

		if (StringValidations.isStringValid(empName) && StringValidations.isStringValid(userType)) {
			String welcomeUser = "Hello " + empName + "\n\nMenu\n";
			inputOutputHandler.displayMethod(welcomeUser);

			int maximumMenuItems = displayMenuItems(userType);

			if (maximumMenuItems > 0) {

				boolean hasSelectedValidMenuItem = false;

				while (hasSelectedValidMenuItem == false) {
					inputOutputHandler.displayMethod(MENU_ITEMS_SELECTION_MESSAGE);
					String menuItemSelection = inputOutputHandler.input();

					try {
						int selectedMenuItem = Integer.parseInt(menuItemSelection);
						boolean isValidMenuSelection = isValidMenuInput(MINIMUM_MENU_ITEMS, maximumMenuItems,
								selectedMenuItem);

						if (isValidMenuSelection == false) {
							throw new IllegalArgumentException();
						}

					} catch (IllegalArgumentException e) {
						inputOutputHandler.displayMethod(ERROR_MESSAGE);
						continue;
					}

					break;
				}
			} else {
				inputOutputHandler.displayMethod(INVALID_INPUT_MESSAGE);
			}
		} else {
			inputOutputHandler.displayMethod(INVALID_INPUT_MESSAGE);
		}
	}

	private int displayMenuItems(String userType) throws Exception {
		List<String> menuItemsList = iMenuItemsByRole.fetchMenuItemsByRole(userType);
		int i = 0;

		for (; i < menuItemsList.size(); i++) {
			String displayMenuItem = "" + (i + 1) + ". " + menuItemsList.get(i);
			inputOutputHandler.displayMethod(displayMenuItem + "\n");
		}

		return i;
	}

	private boolean isValidMenuInput(int minMenuOption, int maxMenuoption, int menuItemSelection) {
		if (menuItemSelection < minMenuOption && menuItemSelection > maxMenuoption) {
			return false;
		}
		return true;
	}

}
