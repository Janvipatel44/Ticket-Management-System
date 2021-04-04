package searchTicket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import searchTicket.interfaces.IConnectionManager;
import searchTicket.interfaces.IdisplayTicket;
import searchTicket.interfaces.IopenTicket;
import searchTicket.interfaces.IstoreTicketData;

public class openTicket implements IopenTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	
	private IstoreTicketData storeTicketData;
	private IdisplayTicket displayUser;
	private IConnectionManager ConnectionMng;
	
	public openTicket(IstoreTicketData storeTicketData, IConnectionManager ConnectionMng)
	{
		this.storeTicketData = storeTicketData; 
		displayUser = new displayTicket();
		this.ConnectionMng = ConnectionMng;
	}

	public void openticket(String ticketId)
	{
		ArrayList<String> singleTicketData = storeTicketData.getSingleTicketData(ticketId);
		List<String> columnOfTable = storeTicketData.getTicketColumns();
		List<String> comments = commentOnTicket(ticketId);
		displayUser.printSignleTicketDetails(singleTicketData,columnOfTable,comments);
		ConnectionMng.closeConnection();
		
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
