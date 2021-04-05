package roles;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import database.IConnectionManager;
import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import mailservice.ReadPropertiesFile;
import roles.interfaces.IRoleManagementDao;

public class RoleManagementDao implements IRoleManagementDao {

	private final String menuItemsByRoleProcedure = "menu_items_by_role";
	private final String updateUserRoleProcedure = "update_user_role";
	private IConnectionManager connectionManager;
	private String projectConfigurationFile = "ProjectConfiguration.properties";
	private String dbConfigurationKey = "DBConfiguration";
	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
	
	public RoleManagementDao() throws IOException {
		Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
		String configurationFile = (String)properties.get(dbConfigurationKey);
		connectionManager = databaseFactory.getConnectionManager(configurationFile);
	}

	@Override
	public List<String> accessMenuItemsByRole(String role) throws Exception {
		
		if(connectionManager == null) {
			throw new Exception("Error while creating connection to DB. Please contact admin.");	
		}
		
		List<String> menuItemsList = null;
		Connection connection = connectionManager.establishConnection();
		CallableStatement procedureCall;
		try {
			procedureCall = connection.prepareCall("call " + menuItemsByRoleProcedure + "(?)");
			procedureCall.setString(1, role);

			boolean isResultSet = procedureCall.execute();

			if (isResultSet) {
				ResultSet resultSet = procedureCall.getResultSet();
				if (resultSet.next()) {
					if (menuItemsList == null) {
						menuItemsList = new ArrayList<String>();
					}
					menuItemsList.add(resultSet.getString(0));
				}
			}
		} catch (SQLException throwables) {
			throw new Exception("Failed during DB operations. Please contact admin.");
		}
		return menuItemsList;
	}

	
	@Override
	public boolean updateUserRole(String empId, String role) throws Exception {
		
		if(connectionManager == null) {
			throw new Exception("Error while creating connection to DB. Please contact admin.");	
		}
		
		Connection connection = connectionManager.establishConnection();
		CallableStatement procedureCall;
		try {
			procedureCall = connection.prepareCall("call " + updateUserRoleProcedure + "(?,?)");
			procedureCall.setString(1, empId);
			procedureCall.setString(2, role);

			int updatedRows = procedureCall.executeUpdate();

			if (updatedRows > 0) {
				return true;
			}
		} catch (SQLException throwables) {
			throw new Exception("Failed during DB operations. Please contact admin.");
		}
		return false;
	}

}
