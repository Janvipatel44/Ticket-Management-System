package reuseablePackage;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import reuseablePackage.interfaces.IStoreTicketData;

public class StoreTicketsData implements IStoreTicketData
{
	static LinkedHashMap<String,ArrayList<String>> ticketData ; 
	static ArrayList<String> commentsOntickets;
	static List<String> columnsOfTable;
			
	public StoreTicketsData()
	{
		ticketData = new LinkedHashMap<String,ArrayList<String>>();; 
		commentsOntickets = new ArrayList<String>();
		columnsOfTable = new ArrayList<String>();
	}

	public void addFetchedTickets(ResultSet resultSet,ResultSetMetaData tableMetaData) 
	{
		ticketData.clear();
		columnsOfTable.clear();
		
		try 
		{
			for(int i=1;i<=tableMetaData.getColumnCount();i++)
			{
				String columnName = tableMetaData.getColumnName(i);
				columnsOfTable.add(columnName);
			}
			
			while (resultSet.next()) 
			{
				ticketData.put(resultSet.getString(columnsOfTable.get(0)), new ArrayList<String>());
				for(int i=1;i<columnsOfTable.size();i++)
				{
					ticketData.get(resultSet.getString(columnsOfTable.get(0))).add(resultSet.getString(columnsOfTable.get(i)));					
				}
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	
	public void addFetchedComments(ResultSet resultSet) 
	{
		commentsOntickets.clear();
		try 
		{
			while (resultSet.next()) 
			{		
				String commentData = resultSet.getString("firstName")+" "+resultSet.getString("lastName")+"\t\t"+resultSet.getDate("date")+
									 "\n"+resultSet.getString("text");
				commentsOntickets.add(commentData);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getSingleTicketData(String TicketID)
	{
		ArrayList<String> singleTicketData = new ArrayList<String>();
		if(ticketData.containsKey(TicketID)) 
		{
			singleTicketData = ticketData.get(TicketID);
			singleTicketData.add(0,TicketID);
			return singleTicketData;
		}
		else
		{
			return singleTicketData;
		}
		
	}
	
	public LinkedHashMap<String,ArrayList<String>> getTableData()
	{
		return ticketData;
	}
	
	public List<String> getTicketColumns()
	{
		return columnsOfTable;
	}
	
	public List<String> getcommentsOnTicket()
	{
		return commentsOntickets;
	}

}