package sortTickets;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.ConnectionManager;
import database.IConnectionManager;
import displayTickets.IdisplayTickets;
import displayTickets.displayTicket;

public class sortTicket implements IsortTicket 
{
	
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	private String ConfigurationFile = "ConfigurationFile";
	
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	IdisplayTickets displaytickettouser = new displayTicket();
	@Override
	public void sortTickets(int choice) 
	{
		try 
		{
			connect = IConnectionMng.establishConnection();
			
			//Stored Procedure call that finds tickets from the system as per the user requirement 
			SPstatement = connect.prepareCall("{call sortTickets(?)}");
			//first parameter decided search option 
			SPstatement.setLong(1,choice);
			hasResult=SPstatement.execute();
			ResultSet resultSet=SPstatement.getResultSet();
			displaytickettouser.displaySearchedOutput(resultSet);
			IConnectionMng.closeConnection();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
	}

}
