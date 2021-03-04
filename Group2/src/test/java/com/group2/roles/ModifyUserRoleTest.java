package com.group2.roles;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ModifyUserRoleTest {

	private final String USER_TYPE = "End_User";
	private final String EMP_ID = "E101";
	private final String NULL_OBJECT = null;
	private final String EMPTY = "";
	private final String INVALID_USER_TYPE = "ABC";
	private final String INVALID_EMP_ID = "16751";
	
	private IModifyUserRole modifyUserRole;
	private IRoleMngmntPersistenceOps iRoleMngmntPersistenceOps;

	@Before
	public void init() {
		iRoleMngmntPersistenceOps = new MenuItemsByRoleDBMock();
		modifyUserRole = new ModifyUserRole(iRoleMngmntPersistenceOps);
	}

	@Test
	public void modifyUserRoleTest() throws Exception {
		boolean isUserModified = modifyUserRole.modifyUserRole(EMP_ID, USER_TYPE);
		assertTrue(isUserModified);
	}
	
	@Test
	public void modifyUserRoleInvalidUserTypeTest() throws Exception {
		boolean isUserModified = modifyUserRole.modifyUserRole(EMP_ID, INVALID_USER_TYPE);
		assertFalse(isUserModified);
	}
	
	@Test
	public void modifyUserRoleNullUserTypeTest() throws Exception {
		boolean isUserModified = modifyUserRole.modifyUserRole(EMP_ID, NULL_OBJECT);
		assertFalse(isUserModified);
	}
	
	@Test
	public void modifyUserRoleEmptyUserTypeTest() throws Exception {
		boolean isUserModified = modifyUserRole.modifyUserRole(EMP_ID, EMPTY);
		assertFalse(isUserModified);
	}
	
	@Test
	public void modifyUserRoleInvalidEmpIdTest() throws Exception {
		boolean isUserModified = modifyUserRole.modifyUserRole(INVALID_EMP_ID, USER_TYPE);
		assertFalse(isUserModified);
	}
	
	@Test
	public void modifyUserRoleNullEmpIdTest() throws Exception {
		boolean isUserModified = modifyUserRole.modifyUserRole(NULL_OBJECT, USER_TYPE);
		assertFalse(isUserModified);
	}
	
	@Test
	public void modifyUserRoleEmptyEmpIdTest() throws Exception {
		boolean isUserModified = modifyUserRole.modifyUserRole(EMPTY, USER_TYPE);
		assertFalse(isUserModified);
	}
}
