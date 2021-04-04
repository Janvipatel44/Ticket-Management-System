package roles.abstractfactory;

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
	public IModifyUserRole makeModifyUserRoleObject() {
		RoleManagementDao roleManagementDao = new RoleManagementDao();
		return new ModifyUserRole(roleManagementDao);
	}

	@Override
	public IMenuItemsByRole makeMenuItemsByRoleObject() {
		RoleManagementDao roleManagementDao = new RoleManagementDao();
		return new MenuItemsByRole(roleManagementDao);
	}
}
