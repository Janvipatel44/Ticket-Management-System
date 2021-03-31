package updateTicketDetails;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionManager;
import database.IConnectionManager;

public class updateTicket implements IupdateTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;

	static String fileName = "ConfigurationFile";
	private IConnectionManager ConnectionMng;
	public updateTicket()
	{
		ConnectionMng = new ConnectionManager(fileName);
	}
	public boolean updateValueOfRow(String ticketID, int choice , String valueToUpdate)
	{
		boolean result = false;
		try 
		{
			connect = ConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call updateTicket(?,?,?)}");
			SPstatement.setLong(1,choice);
			SPstatement.setString(2,ticketID);
			SPstatement.setString(3,valueToUpdate);
			boolean hasResult=SPstatement.execute();
			if(hasResult == false) {
				int count = SPstatement.getUpdateCount();
				if(count > 0)
				{
				   result = true;
				}
		
			}
			ConnectionMng.closeConnection();
		} 
		catch (SQLException e)
		{
				e.printStackTrace();
		}

		return result;
	}
}
