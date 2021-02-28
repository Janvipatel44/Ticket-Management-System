package com.group2.roles;

import java.util.ArrayList;
import java.util.List;

import database.IRoleMngmntPersistenceOps;
import validations.StringValidations;

public class MenuItemsByRoleDBMock implements IRoleMngmntPersistenceOps {

	
	private final String userType = "End_User";
	private final String empId = "E101";
	
	@Override
	public List<String> accessMenuItemsByRole(String role) {
				
		List<String> menuItemsList = null;
		if(StringValidations.isStringValid(role) && role.trim().equalsIgnoreCase(userType)) {
			
			menuItemsList = new ArrayList<String>();
			
			menuItemsList.add("Create ticket");
			menuItemsList.add("Update ticket");
			menuItemsList.add("Reopen the closed ticket");
			menuItemsList.add("Search tickets");
			menuItemsList.add("Rating feature");
			
			return menuItemsList;
		}
			
		return menuItemsList;
	}

	@Override
	public boolean updateUserRole(String empId, String role) {
		
		if (StringValidations.isStringValid(empId) && StringValidations.isStringValid(role)) {
			if(empId.trim().equalsIgnoreCase(this.empId) && role.trim().equalsIgnoreCase(userType)) {
				return true;
			}
		}
		
		return false;
	}
	 
}
