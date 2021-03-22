package openTicketOption;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import StoreTicketData.IstoreTicketData;
import database.ConnectionManager;
import database.IConnectionManager;
import displayTickets.IdisplayTicket;
import displayTickets.displayTicket;

public class openTicket implements IopenTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	private String ConfigurationFile = "ConfigurationFile";
	
	ArrayList<String> singleTicketData;
	ArrayList<String> comments;
	
	private IstoreTicketData storeTicketData;
	private IdisplayTicket displayUser;
	private IConnectionManager ConnectionMng;
	
	public openTicket(IstoreTicketData storeTicketData, IdisplayTicket displayUser, IConnectionManager ConnectionMng)
	{
		this.storeTicketData = storeTicketData; 
		this.displayUser = displayUser;
		this.ConnectionMng = ConnectionMng;
		singleTicketData = new 	ArrayList<String>();
		comments = new 	ArrayList<String>();
	}

	public void openticket(String ticketId)
	{
		singleTicketData = storeTicketData.getSingleTicketData(ticketId);
		comments = commentOnTicket(ticketId);
		displayUser.printSignleTicketDetails(singleTicketData,comments );
		ConnectionMng.closeConnection();
		
	}
	
	private ArrayList<String> commentOnTicket(String ticketId) 
	{
		try 
		{
			connect = ConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call fetchComments(?)}");
			SPstatement.setString(1,ticketId);
			hasResult=SPstatement.execute();
			if(hasResult) {
			    resultSet = SPstatement.getResultSet();
				return (storeTicketData.addFetchedComments(resultSet)) ;
			}
			else
			{
				return null;
			}

		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
