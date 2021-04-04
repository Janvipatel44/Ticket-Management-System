package commentOnTicket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import commentOnTicket.interfaces.IConnectionManager;
import commentOnTicket.interfaces.IdisplayTicket;
import commentOnTicket.interfaces.IgetListOfTickets;
import commentOnTicket.interfaces.IstoreTicketData;

public class getListOfTickets implements IgetListOfTickets
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private String ConfigurationFile = "ConfigurationFile";
	private int choice=4;
	private List<String> listOfTicketsId = new ArrayList<String>();
	
	private IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	private IstoreTicketData storeTicketData = new storeTicketData();
	private IdisplayTicket displayTicket = new displayTicket();
	public getListOfTickets(IstoreTicketData storeTicketData,IdisplayTicket displayTicket,IConnectionManager IConnectionMng)
	{
		this.IConnectionMng = IConnectionMng;
		this.storeTicketData = storeTicketData;
		this.displayTicket = displayTicket;
	}
	
	public void listOfTickets()
	{
		try 
		{
			connect = IConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
			SPstatement.setLong(1,choice);
			SPstatement.setString(2, null);
			boolean hasResult = SPstatement.execute();
			if(hasResult)
			{
			    resultSet = SPstatement.getResultSet();
			    ResultSetMetaData tableMetaData = resultSet.getMetaData();
			    System.out.println("hasresult:"+hasResult + "resultset:"+resultSet );
			    storeTicketData.addFetchedTickets(resultSet,tableMetaData);
			    Map<String, ArrayList <String>> ticketsData = storeTicketData.getTableData();
			    List<String> columnOfTable = storeTicketData.getTicketColumns();
			    displayTicket.printTicketsDetails(ticketsData,columnOfTable);
			}

			IConnectionMng.closeConnection();
		}
		catch (SQLException e)
		{
				e.printStackTrace();
		}
	}
}
