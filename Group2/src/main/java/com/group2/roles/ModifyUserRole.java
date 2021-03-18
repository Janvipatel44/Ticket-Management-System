package com.group2.roles;

import validations.StringValidations;

public class ModifyUserRole implements IModifyUserRole {

	private IRoleManagementDao iRolePersistence;

	public ModifyUserRole (IRoleManagementDao iRolePersistence) {
		this.iRolePersistence = iRolePersistence;
	}
	
	
	@Override
	public boolean modifyUserRole(String empId, String userType) throws Exception {
		
		boolean isUserModified = false;
		
		if (StringValidations.isStringValid(empId) && StringValidations.isStringValid(userType)) {
			isUserModified = iRolePersistence.updateUserRole(empId, userType);
		}
		
		return isUserModified;
	}
	
}
