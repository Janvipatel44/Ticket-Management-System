package sortTickets;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.interfaces.ISortTicket;

public class SortTicket implements ISortTicket 
{
	
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	
	IConnectionManager ConnectionMng;
	IDisplayTicket displayUser;
	IStoreTicketData storeTicketData ;
	
	public SortTicket(IStoreTicketData storeTicketData, IDisplayTicket displayUser, IConnectionManager ConnectionMng)
	{
		this.storeTicketData = storeTicketData; 
		this.displayUser = displayUser;
		this.ConnectionMng = ConnectionMng;
	}
	
	@Override
	public String sortTickets(int choice) 
	{
		String output="";
		try 
		{
			connect = ConnectionMng.establishConnection();
			
			//Stored Procedure call that finds tickets from the system as per the user requirement 
			SPstatement = connect.prepareCall("{call sortTickets(?)}");
			//first parameter decided search option 
			SPstatement.setLong(1,choice);
			SPstatement.execute();
			hasResult=SPstatement.execute();
			if(hasResult)
			{
			    resultSet = SPstatement.getResultSet();
			    ResultSetMetaData tableMetaData = resultSet.getMetaData();
			    storeTicketData.addFetchedTickets(resultSet,tableMetaData);
			    Map<String, ArrayList <String>> ticketsData = storeTicketData.getTableData();
			    List<String> columnOfTable = storeTicketData.getTicketColumns();
			    output = displayUser.printTicketsDetails(ticketsData,columnOfTable);
			}

			ConnectionMng.closeConnection();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return output;
	}

}
