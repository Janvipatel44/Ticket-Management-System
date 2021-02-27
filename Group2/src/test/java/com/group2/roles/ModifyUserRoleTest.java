package com.group2.roles;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ModifyUserRoleTest {

	private final String userType = "End_User";
	private final String empId = "E101";
	
	private IModifyUserRole modifyUserRole;
	private IRoleMngmntPersistenceOps iRoleMngmntPersistenceOps;

	@Before
	public void init() {
		iRoleMngmntPersistenceOps = new MenuItemsByRoleDBMock();
		modifyUserRole = new ModifyUserRole(iRoleMngmntPersistenceOps);
	}

	@Test
	public void modifyUserRoleTest() {
		boolean isUserModified = modifyUserRole.modifyUserRole(this.empId, this.userType);
		assertTrue(isUserModified);
	}
}
