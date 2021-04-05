package reuseablePackage;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.IConnectionManager;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IstoreTicketData;

public class getListOfTickets implements IgetListOfTickets
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private int choice=4;
	private List<String> listOfTicketsId = new ArrayList<String>();
	
	private IConnectionManager IConnectionMng;
	private IstoreTicketData storeTicketData;
	private IdisplayTicket displayTicket;
	
	public getListOfTickets(IstoreTicketData storeTicketData,IdisplayTicket displayTicket,IConnectionManager IConnectionMng)
	{
		this.IConnectionMng = IConnectionMng;
		this.storeTicketData = storeTicketData;
		this.displayTicket = displayTicket;
	}
	
	public String listOfTickets()
	{
		String tableofticket="";
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
			    tableofticket=displayTicket.printTicketsDetails(ticketsData,columnOfTable);
			}
			IConnectionMng.closeConnection();
			
		}
		catch (SQLException e)
		{
				e.printStackTrace();
		}
		return tableofticket;
	}
}
