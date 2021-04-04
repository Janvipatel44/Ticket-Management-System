package searchTicket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import searchTicket.interfaces.IConnectionManager;
import searchTicket.interfaces.IdisplayTicket;
import searchTicket.interfaces.IsearchTicket;
import searchTicket.interfaces.IstoreTicketData;

public class searchTicket implements IsearchTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	
	
	private IstoreTicketData storeTicketData;
	private IdisplayTicket displayUser;
	private IConnectionManager ConnectionMng;
	
	public searchTicket(IstoreTicketData storeTicketData, IConnectionManager ConnectionMng)
	{
		this.storeTicketData = storeTicketData; 
		this.displayUser = new displayTicket();
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
			    ResultSetMetaData tableMetaData = resultSet.getMetaData();
			    System.out.println("hasresult:"+hasResult + "resultset:"+resultSet );
			    storeTicketData.addFetchedTickets(resultSet,tableMetaData);
			    Map<String, ArrayList <String>> ticketsData = storeTicketData.getTableData();
			    List<String> columnOfTable = storeTicketData.getTicketColumns();
			    displayUser.printTicketsDetails(ticketsData,columnOfTable);
			}
	
			ConnectionMng.closeConnection();
		} 
		catch (SQLException e)
		{
				e.printStackTrace();
		}
	}	
}
