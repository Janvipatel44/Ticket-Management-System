package reuseablePackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.IConnectionManager;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;


public class openTicket implements IopenTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	
	private IstoreTicketData storeTicketData;
	private IdisplayTicket displayUser;
	private IConnectionManager ConnectionMng;
	
	public openTicket(IstoreTicketData storeTicketData,IdisplayTicket displayUser, IConnectionManager ConnectionMng)
	{
		this.storeTicketData = storeTicketData; 
		this.displayUser = displayUser;
		this.ConnectionMng = ConnectionMng;
		
	}

	public String openticket(String ticketId)
	{
		ArrayList<String> singleTicketData = storeTicketData.getSingleTicketData(ticketId);
		List<String> columnOfTable = storeTicketData.getTicketColumns();
		List<String> comments = commentOnTicket(ticketId);
		String tableofticket = displayUser.printSignleTicketDetails(singleTicketData,columnOfTable,comments);
		ConnectionMng.closeConnection();
		return tableofticket;

		
	}
	
	private List<String> commentOnTicket(String ticketId) 
	{
		try 
		{
			connect = ConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call fetchComments(?)}");
			SPstatement.setString(1,ticketId);
			hasResult=SPstatement.execute();
			if(hasResult) {
			    resultSet = SPstatement.getResultSet();
				storeTicketData.addFetchedComments(resultSet);
				return(storeTicketData.getcommentsOnTicket());
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
