package reuseablePackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;


public class OpenTicket implements IOpenTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	
	private IStoreTicketData storeTicketData;
	private IDisplayTicket displayUser;
	private IConnectionManager ConnectionMng;
	
	public OpenTicket(IStoreTicketData storeTicketData,IDisplayTicket displayUser, IConnectionManager ConnectionMng)
	{
		this.storeTicketData = storeTicketData; 
		this.displayUser = displayUser;
		this.ConnectionMng = ConnectionMng;
		
	}

	public String openticket(String ticketId)
	{
		List<String> comments;
		String tableofticket="";
		ArrayList<String> singleTicketData = storeTicketData.getSingleTicketData(ticketId);
		List<String> columnOfTable = storeTicketData.getTicketColumns();
		if(singleTicketData.size()>0) {
			comments = commentOnTicket(ticketId);
			tableofticket = displayUser.printSignleTicketDetails(singleTicketData,columnOfTable,comments);
		}
		
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
