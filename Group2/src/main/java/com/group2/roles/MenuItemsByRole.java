package com.group2.roles;

import java.util.List;

import validations.StringValidations;

public class MenuItemsByRole implements IMenuItemsByRole {	
	
	private IRoleMngmntPersistenceOps iRolePersistence;

	public MenuItemsByRole (IRoleMngmntPersistenceOps iRolePersistence) {
		this.iRolePersistence = iRolePersistence;
	}
	
	@Override
	public List<String>  fetchMenuItemsByRole(String userType) throws Exception {
		
		List<String> menuItemsByRole  = null;
		
		if (StringValidations.isStringValid(userType)) {
			menuItemsByRole  = iRolePersistence.accessMenuItemsByRole(userType);
			return menuItemsByRole;
		}
		
		return menuItemsByRole;
	}

}
