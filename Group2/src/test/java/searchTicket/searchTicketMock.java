package searchTicket;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import StoreTicketData.IstoreTicketData;
import database.IConnectionManager;
import displayTickets.IdisplayTicket;
import searchingFunctionality.IsearchTicket;

public class searchTicketMock implements IsearchTicket
{
	private IdisplayTicket displayUser;
	Map<String, ArrayList<String>> ticketsData ;
	public searchTicketMock(IdisplayTicket displayUser)
	{
		this.displayUser = displayUser;
		ticketsData = new LinkedHashMap<String, ArrayList<String>>();
	}
	
	public void searchbyTicket(int choice, String searchInput) 
	{
		if(choice==1)
		{
			if(searchInput.equals("111")) 
			{
				ticketsData.put(searchInput, new ArrayList<String>());
				ticketsData.get(searchInput).add("description: develope bugd free login functionality");
				ticketsData.get(searchInput).add("startDate:2021-03-15");
				ticketsData.get(searchInput).add("endDate:2021-03-30");
				ticketsData.get(searchInput).add("reporterId:EMP12");
				ticketsData.get(searchInput).add("employeeId:EMP123");
				ticketsData.get(searchInput).add("assigneeName:Tejasw");
				ticketsData.get(searchInput).add("ticketType: bug");
				ticketsData.get(searchInput).add("priority:1");
				ticketsData.get(searchInput).add("urgency:3");
			}
		}
		
		else if (choice == 2)
		{
			if(searchInput.equals("Tejasw"))
			{
				ticketsData.put("111", new ArrayList<String>());
				ticketsData.get("111").add("description: develope bugd free login functionality");
				ticketsData.get("111").add("startDate:2021-03-15");
				ticketsData.get("111").add("endDate:2021-03-30");
				ticketsData.get("111").add("reporterId:EMP12");
				ticketsData.get("111").add("employeeId:EMP123");
				ticketsData.get("111").add("assigneeName:"+searchInput);
				ticketsData.get("111").add("ticketType: bug");
				ticketsData.get("111").add("priority:1");
				ticketsData.get("111").add("urgency:3");
			}
			
		}
		else if (choice == 3)
		{
			if(searchInput.equals("bug"))
			{
				ticketsData.put("111", new ArrayList<String>());
				ticketsData.get("111").add("description: develope bugd free login functionality");
				ticketsData.get("111").add("startDate:2021-03-15");
				ticketsData.get("111").add("endDate:2021-03-30");
				ticketsData.get("111").add("reporterId:EMP12");
				ticketsData.get("111").add("employeeId:EMP123");
				ticketsData.get("111").add("assigneeName:"+searchInput);
				ticketsData.get("111").add("ticketType:"+searchInput);
				ticketsData.get("111").add("priority:1");
				ticketsData.get("111").add("urgency:3");
			}
		}
		else if (choice == 4)
		{
			ticketsData.put("111", new ArrayList<String>());
			ticketsData.get("111").add("description: develope bugd free login functionality");
			ticketsData.get("111").add("startDate:2021-03-15");
			ticketsData.get("111").add("endDate:2021-03-30");
			ticketsData.get("111").add("reporterId:EMP12");
			ticketsData.get("111").add("employeeId:EMP123");
			ticketsData.get("111").add("assigneeName:bug");
			ticketsData.get("111").add("ticketType: bug");
			ticketsData.get("111").add("priority:1");
			ticketsData.get("111").add("urgency:3");
		}
		else if (choice == 5)
				
		{
			if(searchInput.equals("EMP123"))
			{
				ticketsData.put("111", new ArrayList<String>());
				ticketsData.get("111").add("description: develope bugd free login functionality");
				ticketsData.get("111").add("startDate:2021-03-15");
				ticketsData.get("111").add("endDate:2021-03-30");
				ticketsData.get("111").add("reporterId:EMP12");
				ticketsData.get("111").add("employeeId:"+searchInput);
				ticketsData.get("111").add("assigneeName:"+searchInput);
				ticketsData.get("111").add("ticketType: bug");
				ticketsData.get("111").add("priority:1");
				ticketsData.get("111").add("urgency:3");
			}
		}
		else if (choice == 6)
		{
			if(searchInput.contains("login"))
			{
				ticketsData.put("111", new ArrayList<String>());
				ticketsData.get("111").add("description: develope bugd free"+ searchInput +"functionality");
				ticketsData.get("111").add("startDate:2021-03-15");
				ticketsData.get("111").add("endDate:2021-03-30");
				ticketsData.get("111").add("reporterId:EMP12");
				ticketsData.get("111").add("employeeId:EMP123");
				ticketsData.get("111").add("assigneeName:"+searchInput);
				ticketsData.get("111").add("ticketType: bug");
				ticketsData.get("111").add("priority:1");
				ticketsData.get("111").add("urgency:3");
			}
		}
		displayUser.printTicketsDetails(ticketsData);
	}	
}
