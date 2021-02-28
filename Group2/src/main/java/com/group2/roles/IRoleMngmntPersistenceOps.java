package com.group2.roles;

import java.sql.SQLException;
import java.util.List;

public interface IRoleMngmntPersistenceOps {
	
	List<String> accessMenuItemsByRole(String role);
	
	boolean updateUserRole(String empId, String role);
}
