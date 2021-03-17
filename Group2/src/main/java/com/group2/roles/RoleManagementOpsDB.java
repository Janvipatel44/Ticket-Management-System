package com.group2.roles;

import java.sql.Connection;
import java.util.List;

public class RoleManagementOpsDB implements IRoleMngmntPersistenceOps {

	private Connection connection;
	
	public RoleManagementOpsDB(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<String> accessMenuItemsByRole(String role) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean updateUserRole(String empId, String role) {
		// TODO Auto-generated method stub
		return false;
	}
	 
}
