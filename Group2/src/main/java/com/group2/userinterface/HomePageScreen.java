package com.group2.userinterface;

import java.util.List;

import com.group2.roles.IMenuItemsByRole;

import validations.StringValidations;

public class HomePageScreen implements IHomePageScreen {

	private IMenuItemsByRole iMenuItemsByRole;
	IInputOutputHandler inputOutputHandler;

	private final String menuItemSelectionMessage = "Please select the item from menu (provide corresponding menu item number) : ";
	private final String errorMessage = "You have provided wrong input. Please choose the correct input from menu.";
	private final int minimumMenuItems = 1;

	
	public HomePageScreen(IMenuItemsByRole iMenuItemsByRole, IInputOutputHandler inputOutputHandler) {
		this.iMenuItemsByRole = iMenuItemsByRole;
		this.inputOutputHandler = inputOutputHandler;
	}

	
	public void handleHomePageMenu(String empName, String userType) {

		if (StringValidations.isStringValid(empName) && StringValidations.isStringValid(userType)) {
			String welcomeUser = "Hello " + empName + "\n\nMenu\n";
			inputOutputHandler.displayMethod(welcomeUser);

			int maximumMenuItems = displayMenuItems(userType);
			
			boolean hasSelectedValidMenuItem = false;
			
			while(hasSelectedValidMenuItem == false) {
				
				inputOutputHandler.displayMethod(menuItemSelectionMessage);
				String menuItemSelection = inputOutputHandler.input();

				try {
					int selectedMenuItem = Integer.parseInt(menuItemSelection);
					
					boolean isValidMenuSelection = isValidMenuInput(minimumMenuItems, maximumMenuItems, selectedMenuItem);
					
					if(isValidMenuSelection == false) {
						throw new IllegalArgumentException();
					}

				} catch (IllegalArgumentException e) {
					inputOutputHandler.displayMethod(errorMessage);
					continue;
				}
				
				break;
			}
		}
	}

	
	private int displayMenuItems(String userType) {
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
