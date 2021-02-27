package com.group2.roles;

import org.junit.Before;
import org.junit.Test;

import com.group2.userinterface.HomePageScreen;
import com.group2.userinterface.IHomePageScreen;
import com.group2.userinterface.IInputOutputHandler;
import com.group2.userinterface.InputOutputHandler;

public class MenuItemsByRoleTest {
	
	private final String userType = "End_User";
	private final String empName = "Akshay";
	private IMenuItemsByRole menuItemsByRole;
	private IRoleMngmntPersistenceOps iRoleMngmntPersistenceOps;
	private IHomePageScreen homePageScreen;
	private IInputOutputHandler inputOutputHandler;

	@Before
	public void init() {
		iRoleMngmntPersistenceOps = new MenuItemsByRoleDBMock();
		inputOutputHandler = new InputOutputHandler();
		menuItemsByRole = new MenuItemsByRole(iRoleMngmntPersistenceOps);
		homePageScreen = new HomePageScreen(menuItemsByRole, inputOutputHandler);
	}

	@Test
	public void  createUserTaskMenuTest() {
//		homePageScreen.createUserTaskMenu(this.empName, this.userType);
	}
}
