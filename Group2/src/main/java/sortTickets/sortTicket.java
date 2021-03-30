package sortTickets;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import StoreTicketData.IstoreTicketData;
import database.IConnectionManager;
import displayTickets.IdisplayTicket;

public class sortTicket implements IsortTicket 
{
	
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	
	IConnectionManager ConnectionMng;
	IdisplayTicket displayUser;
	IstoreTicketData storeTicketData ;
	
	public sortTicket(IstoreTicketData storeTicketData, IdisplayTicket displayUser, IConnectionManager ConnectionMng)
	{
		this.storeTicketData = storeTicketData; 
		this.displayUser = displayUser;
		this.ConnectionMng = ConnectionMng;
	}
	
	@Override
	public void sortTickets(int choice) 
	{
		try 
		{
			connect = ConnectionMng.establishConnection();
			
			//Stored Procedure call that finds tickets from the system as per the user requirement 
			SPstatement = connect.prepareCall("{call sortTickets(?)}");
			//first parameter decided search option 
			SPstatement.setLong(1,choice);
			SPstatement.execute();
			ResultSet resultSet=SPstatement.getResultSet();
			Map<String, ArrayList <String>> ticketsData = storeTicketData.addFetchedTickets(resultSet);
			System.out.println(ticketsData);
		    displayUser.printTicketsDetails(ticketsData);
		    ConnectionMng.closeConnection();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
	}

}
