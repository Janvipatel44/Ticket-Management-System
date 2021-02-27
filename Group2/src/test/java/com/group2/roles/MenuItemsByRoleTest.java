package com.group2.roles;

import org.junit.Before;
import org.junit.Test;

import com.group2.userinterface.HomePageScreen;
import com.group2.userinterface.IHomePageScreen;

public class MenuItemsByRoleTest {
	
	private final String userType = "End_User";
	private final String empName = "Akshay";
	private IMenuItemsByRole menuItemsByRole;
	private IRoleMngmntPersistenceOps iRoleMngmntPersistenceOps;
	private IHomePageScreen homePageScreen;

	@Before
	public void init() {
		iRoleMngmntPersistenceOps = new MenuItemsByRoleDBMock();
		menuItemsByRole = new MenuItemsByRole(iRoleMngmntPersistenceOps);
		homePageScreen = new HomePageScreen(menuItemsByRole);
	}

	@Test
	public void  createUserTaskMenuTest() {
//		homePageScreen.createUserTaskMenu(this.empName, this.userType);
	}
}
