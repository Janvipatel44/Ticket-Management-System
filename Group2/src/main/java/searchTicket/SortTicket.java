package searchTicket;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.interfaces.ISortTicket;

public class SortTicket implements ISortTicket 
{
	IDisplayTickets displayUser;
	IStoreTicketData storeTicketData ;
	
	public SortTicket(IStoreTicketData storeTicketData, IDisplayTickets displayUser)
	{
		this.storeTicketData = storeTicketData; 
		this.displayUser = displayUser;
	}
	
	
	public String sortSearchedTickets(int choiceToSortTicket)
	{
		 LinkedHashMap<String, ArrayList <String>> ticketsData = storeTicketData.getTableData();
		 List<String> columnOfTable = storeTicketData.getTicketColumns();
		 LinkedHashMap<String, ArrayList <String>> SortedTicketData=new LinkedHashMap<String, ArrayList <String>>();
		 if(ticketsData.size()==1)
		{
			String output = "Already Sorted output";
			return output;
		}
		 else if(choiceToSortTicket == 1)
		{
			 SortedTicketData = sortByPriority(ticketsData);
			 
		}
		else if(choiceToSortTicket == 2)
		{
			SortedTicketData = sortByUrgency(ticketsData);
		}
		else if(choiceToSortTicket == 3)
		{
			SortedTicketData = sortByImpact(ticketsData);
		}
		String output = displayUser.printTicketsDetails(SortedTicketData,columnOfTable);
		return output;
	}

	private LinkedHashMap<String, ArrayList <String>> sortByPriority(LinkedHashMap<String, ArrayList<String>> ticketsData) {
		int Priority=9;
		LinkedHashMap<String, ArrayList <String>> sortData=sortTicketLogic(ticketsData,Priority);
		return sortData;
		
	}
	
	private LinkedHashMap<String, ArrayList <String>> sortByUrgency(LinkedHashMap<String, ArrayList<String>> ticketsData) {
		
		int urgency=10;
		LinkedHashMap<String, ArrayList <String>> sortData=sortTicketLogic(ticketsData,urgency);
		
		return sortData;
		
	}

	private LinkedHashMap<String, ArrayList <String>> sortByImpact(LinkedHashMap<String, ArrayList<String>> ticketsData) {
		
		int impact=11;
		LinkedHashMap<String, ArrayList <String>> sortData=sortTicketLogic(ticketsData,impact);
		
		return sortData;
	}
	
	private LinkedHashMap<String, ArrayList <String>> sortTicketLogic(LinkedHashMap<String, ArrayList<String>> ticketsData,int index)
	{
		LinkedHashMap<String, ArrayList <String>> sortData=new LinkedHashMap<String, ArrayList <String>>();
		Map<String, ArrayList <String>> temp=ticketsData;
		int max=0;
		int flag=0;
		String innerKey="";
		if(ticketsData.size()>1) {
			for(int i=0;i<ticketsData.size();i++) {
				for(String keyOuter : temp.keySet())
				{
					if(sortData.containsKey(keyOuter))
					{
						continue;
					}
					flag=0;
					innerKey=keyOuter;
					max = Integer.parseInt(ticketsData.get(keyOuter).get(index));
					for(String keyInner: temp.keySet())
					{
						if(sortData.containsKey(keyInner))
						{
							continue;
						}
						int urgency=Integer.parseInt(ticketsData.get(keyInner).get(index));
						
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
			
		}
		return sortData;
	}
}
