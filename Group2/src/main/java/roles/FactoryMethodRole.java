package roles;

import database.ConnectionManager;

public class FactoryMethodRole {

	public IModifyUserRole getModifyUserRoleObject(ConnectionManager connectionManager) {
		if(connectionManager == null) {
			return null;
		}
		RoleManagementDao roleManagementDao = new RoleManagementDao(connectionManager);
		return new ModifyUserRole(roleManagementDao);
	}

	public IMenuItemsByRole getMenuItemsByRoleObject(ConnectionManager connectionManager) {
		if(connectionManager == null) {
			return null;
		}
		RoleManagementDao roleManagementDao = new RoleManagementDao(connectionManager);
		return new MenuItemsByRole(roleManagementDao);
	}
}
