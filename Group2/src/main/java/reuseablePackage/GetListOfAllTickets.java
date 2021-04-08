package reuseablePackage;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IStoreTicketData;

public class GetListOfAllTickets implements IGetListOfTickets
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private int choice=4;
	private List<String> listOfTicketsId = new ArrayList<String>();
	
	private IConnectionManager IConnectionMng;
	private IStoreTicketData storeTicketData;
	private IDisplayTickets displayTicket;
	
	public GetListOfAllTickets(IStoreTicketData storeTicketData,IDisplayTickets displayTicket,IConnectionManager IConnectionMng)
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
