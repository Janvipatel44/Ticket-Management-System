package roles.abstractfactory;

import roles.interfaces.IMenuItemsByRole;
import roles.interfaces.IModifyUserRole;

public interface IRoleFactory {

	IMenuItemsByRole makeMenuItemsByRoleObject();

	IModifyUserRole makeModifyUserRoleObject();

}