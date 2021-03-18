package com.group2.roles;

import org.junit.Before;

import com.group2.userinterface.IInputOutputHandler;
import com.group2.userinterface.InputOutputHandler;

public class HomePageScreenTest {

	private final String USER_TYPE = "End_User";
	private final String EMP_NAME = "Akshay";
	
	private IHomePageScreen homePageScreen;
	private IMenuItemsByRole menuItemsByRole;
	private IRoleManagementDao iRoleMngmntPersistenceOps;
	private IInputOutputHandler inputOutputHandler;

	@Before
	public void init() {
		iRoleMngmntPersistenceOps = new MenuItemsByRoleDBMock();
		menuItemsByRole = new MenuItemsByRole(iRoleMngmntPersistenceOps);
		inputOutputHandler = new InputOutputHandler();
		homePageScreen = new HomePageScreen(menuItemsByRole, inputOutputHandler);
	}
	
	public void handleHomePageMenuTest() {
		
	}
	
}
