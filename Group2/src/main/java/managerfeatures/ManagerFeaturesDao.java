package managerfeatures;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import Tickets.CreateTicket;
import Tickets.ICreateTicket;
import database.IConnectionManager;
import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import mailservice.ReadPropertiesFile;
import managerfeatures.interfaces.IManagerFeaturesDao;

public class ManagerFeaturesDao implements IManagerFeaturesDao {

	private final String MANAGER_TEAM_TICKETS = "managers_team_tickets";
	private IConnectionManager connectionManager;
	private String projectConfigurationFile = "ProjectConfiguration.properties";
	private String dbConfigurationKey = "DBConfiguration";
	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();

	public ManagerFeaturesDao() throws IOException {
		Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
		String configurationFile = (String)properties.get(dbConfigurationKey);
		connectionManager = databaseFactory.getConnectionManager(configurationFile);
	}
	
	
	@Override
	public List<ICreateTicket> managersTeamTickets(String managerId) throws Exception {
		
		List<ICreateTicket> createTickets = new ArrayList<ICreateTicket>();
		
		if(connectionManager == null) {
			throw new Exception("Error while creating connection to DB. Please contact admin.");	
		}
		
		Connection connection = connectionManager.establishConnection();
		CallableStatement procedureCall;
		try {
			procedureCall = connection.prepareCall("call " + MANAGER_TEAM_TICKETS + "(?)");
			procedureCall.setString(1, managerId);

			boolean isResultSet = procedureCall.execute();

			if (isResultSet) {
				ResultSet resultSet = procedureCall.getResultSet();
				if (resultSet.next()) {
					ICreateTicket createTicket = new CreateTicket();
					createTicket.setEmployeeId(resultSet.getString(1));
					createTicket.setTicketId(resultSet.getString(2));
					createTicket.setDescription(resultSet.getString(3));
					createTickets.add(createTicket);
				}
			}
		} catch (SQLException throwables) {
			throw new Exception("Failed during DB operations. Please contact admin.");
		}
		return createTickets;
	}

}
