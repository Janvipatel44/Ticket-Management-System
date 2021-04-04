package reuseablePackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionManager;
import database.IConnectionManager;
import reuseablePackage.interfaces.IcheckTicketExists;

public class checkTicketExists  implements IcheckTicketExists
{
	
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private String ConfigurationFile = "ConfigurationFile";
	private int choice=1;
	private IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	
	public boolean ticketExists(String ticketID)
	{
		try 
		{
			connect = IConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
			SPstatement.setLong(1,choice);
			SPstatement.setString(2,ticketID);
			SPstatement.execute();
			resultSet = SPstatement.getResultSet();
			
			if(resultSet.next())
			{
				IConnectionMng.closeConnection();
				return true;
				
			}
			else
			{
				IConnectionMng.closeConnection();
				return false;
			}
			
		}
		catch (SQLException e)
		{
				e.printStackTrace();
				return false;
		}
		
		
	}
}
