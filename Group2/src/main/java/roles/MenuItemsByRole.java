package roles;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class MenuItemsByRole implements IMenuItemsByRole {	
	
	private IRoleManagementDao roleManagementDao;

	public MenuItemsByRole (IRoleManagementDao roleManagementDao) {
		this.roleManagementDao = roleManagementDao;
	}
	
	@Override
	public List<String>  fetchMenuItemsByRole(String userType) throws Exception {
		
		List<String> menuItemsByRole = null;
		
		if (StringUtils.isNotBlank(userType)) {
			menuItemsByRole  = roleManagementDao.accessMenuItemsByRole(userType);
			return menuItemsByRole;
		}
		
		return menuItemsByRole;
	}

}
