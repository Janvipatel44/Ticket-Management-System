package com.group2.roles;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import database.IRoleMngmntPersistenceOps;

public class MenuItemsByRoleTest {
	
	private final String userType = "End_User";
	private IMenuItemsByRole menuItemsByRole;
	private IRoleMngmntPersistenceOps iRoleMngmntPersistenceOps;

	@Before
	public void init() {
		iRoleMngmntPersistenceOps = new MenuItemsByRoleDBMock();
		menuItemsByRole = new MenuItemsByRole(iRoleMngmntPersistenceOps);
	}

	@Test
	public void  createUserTaskMenuTest() throws Exception {
		List<String> menuItemsList = menuItemsByRole.fetchMenuItemsByRole(userType);
	}
}
