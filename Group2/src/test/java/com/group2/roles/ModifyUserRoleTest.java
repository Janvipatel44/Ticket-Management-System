package com.group2.roles;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import database.IRoleMngmntPersistenceOps;

public class ModifyUserRoleTest {

	private final String USER_TYPE = "End_User";
	private final String EMP_ID = "E101";
	
	private IModifyUserRole modifyUserRole;
	private IRoleMngmntPersistenceOps iRoleMngmntPersistenceOps;

	@Before
	public void init() {
		iRoleMngmntPersistenceOps = new MenuItemsByRoleDBMock();
		modifyUserRole = new ModifyUserRole(iRoleMngmntPersistenceOps);
	}

	@Test
	public void modifyUserRoleTest() throws Exception {
		boolean isUserModified = modifyUserRole.modifyUserRole(USER_TYPE, EMP_ID);
		assertTrue(isUserModified);
	}
}
