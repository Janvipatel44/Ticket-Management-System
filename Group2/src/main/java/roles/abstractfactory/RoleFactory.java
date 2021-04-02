package roles.abstractfactory;

import database.ConnectionManager;
import roles.MenuItemsByRole;
import roles.ModifyUserRole;
import roles.RoleManagementDao;
import roles.interfaces.IMenuItemsByRole;
import roles.interfaces.IModifyUserRole;

public class RoleFactory implements IRoleFactory {

	private static IRoleFactory uniqueInstance = null;		
	
	private RoleFactory() {
	}

	public static IRoleFactory instance() {
		if(null == uniqueInstance) {
			uniqueInstance = new RoleFactory();
		}
		return uniqueInstance;
	}
	
	@Override
	public IModifyUserRole makeModifyUserRoleObject(ConnectionManager connectionManager) {
		if(connectionManager == null) {
			return null;
		}
		RoleManagementDao roleManagementDao = new RoleManagementDao(connectionManager);
		return new ModifyUserRole(roleManagementDao);
	}

	@Override
	public IMenuItemsByRole makeMenuItemsByRoleObject(ConnectionManager connectionManager) {
		if(connectionManager == null) {
			return null;
		}
		RoleManagementDao roleManagementDao = new RoleManagementDao(connectionManager);
		return new MenuItemsByRole(roleManagementDao);
	}
}
