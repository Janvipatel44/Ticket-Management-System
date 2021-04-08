package searchTicket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

<<<<<<< HEAD:Group2/src/main/java/searchTicket/SearchTicket.java
import database.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.interfaces.ISearchTicket;
=======
import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import searchTicket.interfaces.IsearchTicket;
>>>>>>> 5a2ea7b7154c35580472c415ac24ce2ced02e5a3:Group2/src/main/java/searchTicket/searchTicket.java

public class SearchTicket implements ISearchTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	
	
	private IStoreTicketData storeTicketData;
	private IDisplayTicket displayUser;
	private IConnectionManager ConnectionMng;
	
	public SearchTicket(IStoreTicketData storeTicketData,IDisplayTicket displayuser, IConnectionManager ConnectionMng)
	{
		this.storeTicketData = storeTicketData; 
		this.displayUser = displayuser;
		this.ConnectionMng = ConnectionMng;
	}
	public String searchbyTicket(int choice, String searchInput) 
	{
		String output="";
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
			    storeTicketData.addFetchedTickets(resultSet,tableMetaData);
			    LinkedHashMap<String,ArrayList<String>> ticketData = storeTicketData.getTableData();
			    List<String> columnOfTable = storeTicketData.getTicketColumns();
			    if(ticketData.size()>0)
			    {
			    	 output = displayUser.printTicketsDetails(ticketData,columnOfTable);
			    }
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
