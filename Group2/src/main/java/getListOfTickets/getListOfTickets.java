package getListOfTickets;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionManager;
import database.IConnectionManager;
import displayTickets.IdisplayTickets;
import displayTickets.displayTickets;

public class getListOfTickets implements IgetListOfTickets
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private String ConfigurationFile = "ConfigurationFile";
	private int choice=4;
	private List<String> listOfTicketsId = new ArrayList<String>();
	
	private IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	private IdisplayTickets displaytickets = new displayTickets();
	
	public void listOfTickets()
	{
		try 
		{
			connect = IConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
			SPstatement.setLong(1,choice);
			SPstatement.setString(2, null);
			SPstatement.execute();
			resultSet = SPstatement.getResultSet();
			
			while(resultSet.next())
			{
				String ticket=resultSet.getString("ticketId") +"\n"+"\t"+"\t"+"Description:"+resultSet.getString("description");
				listOfTicketsId.add(ticket);
			}
			displaytickets.displayTickets(listOfTicketsId);
		}
		catch (SQLException e)
		{
				e.printStackTrace();
		}
	}
}
