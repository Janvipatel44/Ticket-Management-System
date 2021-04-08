package sortTickets;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.interfaces.ISortTicket;

public class SortTicket implements ISortTicket 
{
	
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	
	IConnectionManager ConnectionMng;
	IDisplayTickets displayUser;
	IStoreTicketData storeTicketData ;
	
	public SortTicket(IStoreTicketData storeTicketData, IDisplayTickets displayUser, IConnectionManager ConnectionMng)
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
	
	public String sortSearchedTickets(int choiceToSortTicket)
	{
		 Map<String, ArrayList <String>> ticketsData = storeTicketData.getTableData();
		 List<String> columnOfTable = storeTicketData.getTicketColumns();
		 LinkedHashMap<String, ArrayList <String>> SortedTicketData=new LinkedHashMap<String, ArrayList <String>>();
		if(choiceToSortTicket == 1)
		{
			 SortedTicketData = sortByPriority(ticketsData);
			 
		}
		else if(choiceToSortTicket == 2)
		{
			SortedTicketData = sortByImpact(ticketsData);
		}
		else if(choiceToSortTicket == 3)
		{
			SortedTicketData = sortByUrgency(ticketsData);
		}
		String output = displayUser.printTicketsDetails(SortedTicketData,columnOfTable);
		return output;
	}

	private LinkedHashMap<String, ArrayList <String>> sortByPriority(Map<String, ArrayList<String>> ticketsData) {
		int urgencyIndex=10;
		LinkedHashMap<String, ArrayList <String>> sortData=sortTicketLogic(ticketsData,urgencyIndex);
		return sortData;
		
	}
	
	private LinkedHashMap<String, ArrayList <String>> sortByUrgency(Map<String, ArrayList<String>> ticketsData) {
		
		int urgencyIndex=11;
		LinkedHashMap<String, ArrayList <String>> sortData=sortTicketLogic(ticketsData,urgencyIndex);
		
		return sortData;
		
	}

	private LinkedHashMap<String, ArrayList <String>> sortByImpact(Map<String, ArrayList<String>> ticketsData) {
		
		int urgencyIndex=12;
		LinkedHashMap<String, ArrayList <String>> sortData=sortTicketLogic(ticketsData,urgencyIndex);
		
		return sortData;
	}
	
	private LinkedHashMap<String, ArrayList <String>> sortTicketLogic(Map<String, ArrayList<String>> ticketsData,int index)
	{
		LinkedHashMap<String, ArrayList <String>> sortData=new LinkedHashMap<String, ArrayList <String>>();
		Map<String, ArrayList <String>> temp=ticketsData;
		int max=0;
		int flag=0;
		String innerKey="";
		System.out.println(ticketsData);
		for(int i=0;i<ticketsData.size();i++) {
			for(String keyOuter : temp.keySet())
			{
				if(sortData.containsKey(keyOuter))
				{
					continue;
				}
				flag=0;
				innerKey=keyOuter;
				max = Integer.parseInt(ticketsData.get(keyOuter).get(11));
				for(String keyInner: temp.keySet())
				{
					if(sortData.containsKey(keyInner))
					{
						continue;
					}
					int urgency=Integer.parseInt(ticketsData.get(keyInner).get(11));
					
					System.out.println(max +":"+urgency);
					if(max>urgency)
					{
						flag=1;
						break;
					}
					
				}
				if(flag==0)
				{
					if(sortData.containsKey(innerKey))
					{
						continue;
					}
					else {
						sortData.put(innerKey, new ArrayList<String>());
						sortData.put(innerKey,ticketsData.get(innerKey));
					}
					
				}
				if(sortData.size()==ticketsData.size())
				{
					break;
				}
			}
		
			
		}
		System.out.print(sortData+":"+sortData.size()+":"+ticketsData.size());
		return sortData;
	}
}
