package updateTicketDetails;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionManager;
import database.IConnectionManager;
import updateTicketDetails.interfaces.IdeleteTicket;

public class deleteTicket implements IdeleteTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private String ConfigurationFile = "ConfigurationFile";
	
	private IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	

	public boolean deleteticket(String ticketId)
	{
		try 
		{
			connect = IConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call deleteticket(?)}");
			SPstatement.setString(1,ticketId);
			SPstatement.execute();
			IConnectionMng.closeConnection();
			return true;
		} 
		catch (SQLException e)
		{
				e.printStackTrace();
				return false;
		}
	}			
}
