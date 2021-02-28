package database;

import java.util.List;

public interface IRoleMngmntPersistenceOps {
	
	List<String> accessMenuItemsByRole(String role) throws Exception;
	
	boolean updateUserRole(String empId, String role) throws Exception;
}
