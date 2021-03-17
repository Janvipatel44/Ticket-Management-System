package com.group2.userinterface;

import org.junit.Before;

import com.group2.roles.IMenuItemsByRole;
import com.group2.roles.IRoleMngmntPersistenceOps;
import com.group2.roles.MenuItemsByRole;
import com.group2.roles.MenuItemsByRoleDBMock;

public class HomePageScreenTest {

	private final String userType = "End_User";
	private IMenuItemsByRole menuItemsByRole;
	private IRoleMngmntPersistenceOps iRoleMngmntPersistenceOps;

	@Before
	public void init() {
		iRoleMngmntPersistenceOps = new MenuItemsByRoleDBMock();
		menuItemsByRole = new MenuItemsByRole(iRoleMngmntPersistenceOps);
	}
	
	public void createUserTaskMenu() {
		
	}
	
}
