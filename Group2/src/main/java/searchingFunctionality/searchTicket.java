package searchingFunctionality;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import StoreTicketData.IstoreTicketData;
import database.ConnectionManager;
import database.IConnectionManager;
import displayTickets.IdisplayTicket;
import displayTickets.displayTicket;

public class searchTicket implements IsearchTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	
	private IstoreTicketData storeTicketData;
	private IdisplayTicket displayUser;
	private IConnectionManager ConnectionMng;
	
	public searchTicket(IstoreTicketData storeTicketData, IdisplayTicket displayUser, IConnectionManager ConnectionMng)
	{
		this.storeTicketData = storeTicketData; 
		this.displayUser = displayUser;
		this.ConnectionMng = ConnectionMng;
	}
	public void searchbyTicket(int choice, String searchInput) 
	{
		try 
		{
			connect = ConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
			SPstatement.setLong(1,choice);
			SPstatement.setString(2,searchInput);
			hasResult=SPstatement.execute();
			if(hasResult)
			{
			    resultSet = SPstatement.getResultSet();
			    System.out.println("hasresult:"+hasResult + "resultset:"+resultSet );
			    Map<String, ArrayList <String>> ticketsData = storeTicketData.addFetchedTickets(resultSet);
			    displayUser.printTicketsDetails(ticketsData);
			}
	
			ConnectionMng.closeConnection();
		} 
		catch (SQLException e)
		{
				e.printStackTrace();
		}
	}	
}
