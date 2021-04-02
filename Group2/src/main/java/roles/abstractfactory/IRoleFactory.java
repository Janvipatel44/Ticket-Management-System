package roles.abstractfactory;

import database.ConnectionManager;
import roles.interfaces.IMenuItemsByRole;
import roles.interfaces.IModifyUserRole;

public interface IRoleFactory {

	IMenuItemsByRole makeMenuItemsByRoleObject(ConnectionManager connectionManager);

	IModifyUserRole makeModifyUserRoleObject(ConnectionManager connectionManager);

}