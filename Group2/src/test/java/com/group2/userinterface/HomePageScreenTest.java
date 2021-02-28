package com.group2.userinterface;

import org.junit.Before;

import com.group2.roles.IMenuItemsByRole;
import com.group2.roles.MenuItemsByRole;
import com.group2.roles.MenuItemsByRoleDBMock;

import database.IRoleMngmntPersistenceOps;

public class HomePageScreenTest {

	private final String userType = "End_User";
	private final String empName = "Akshay";
	
	private IHomePageScreen homePageScreen;
	private IMenuItemsByRole menuItemsByRole;
	private IRoleMngmntPersistenceOps iRoleMngmntPersistenceOps;
	private IInputOutputHandler inputOutputHandler;

	@Before
	public void init() {
		inputOutputHandler = new InputOutputHandler();
		menuItemsByRole = new MenuItemsByRole(iRoleMngmntPersistenceOps);
		homePageScreen = new HomePageScreen(menuItemsByRole, inputOutputHandler);
	}
	
	public void createUserTaskMenu() {
		
	}
	
}
