package sortTicketTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import displayTickets.IdisplayTicket;
import sortTickets.IsortTicket;

public class sortTicketMock implements IsortTicket
{
	private IdisplayTicket displayUser;
	Map<String, ArrayList<String>> ticketsData ;
	public sortTicketMock(IdisplayTicket displayUser)
	{
		this.displayUser = displayUser;
		ticketsData = new LinkedHashMap<String, ArrayList<String>>();
	}
	@Override
	public void sortTickets(int choice)
	{
		if(choice ==1)
		{
			ticketsData.put("111", new ArrayList<String>());
			ticketsData.get("111").add("develope bugd free login functionality");
			ticketsData.get("111").add("2021-03-15");
			ticketsData.get("111").add("2021-03-30");
			ticketsData.get("111").add("EMP12");
			ticketsData.get("111").add("EMP123");
			ticketsData.get("111").add("Tejasw");
			ticketsData.get("111").add("bug");
			ticketsData.get("111").add("1");
			ticketsData.get("111").add("3");
			ticketsData.get("111").add("3");
			
			ticketsData.put("123", new ArrayList<String>());
			ticketsData.get("123").add("develope bugd free login functionality");
			ticketsData.get("123").add("2021-03-15");
			ticketsData.get("123").add("2021-03-30");
			ticketsData.get("123").add("EMP12");
			ticketsData.get("123").add("EMP123");
			ticketsData.get("123").add("Tejasw");
			ticketsData.get("123").add("bug");
			ticketsData.get("123").add("2");
			ticketsData.get("123").add("3");
			ticketsData.get("123").add("3");

		}
		else if (choice ==2)
		{
			ticketsData.put("111", new ArrayList<String>());
			ticketsData.get("111").add("develope bugd free login functionality");
			ticketsData.get("111").add("2021-03-15");
			ticketsData.get("111").add("2021-03-30");
			ticketsData.get("111").add("EMP12");
			ticketsData.get("111").add("EMP123");
			ticketsData.get("111").add("Tejasw");
			ticketsData.get("111").add("bug");
			ticketsData.get("111").add("1");
			ticketsData.get("111").add("1");
			ticketsData.get("111").add("3");
			
			ticketsData.put("123", new ArrayList<String>());
			ticketsData.get("123").add("develope bugd free login functionality");
			ticketsData.get("123").add("2021-03-15");
			ticketsData.get("123").add("2021-03-30");
			ticketsData.get("123").add("EMP12");
			ticketsData.get("123").add("EMP123");
			ticketsData.get("123").add("Tejasw");
			ticketsData.get("123").add("bug");
			ticketsData.get("123").add("2");
			ticketsData.get("123").add("2");
			ticketsData.get("123").add("3");

		}
		else if (choice ==3)
		{
			ticketsData.put("111", new ArrayList<String>());
			ticketsData.get("111").add("develope bugd free login functionality");
			ticketsData.get("111").add("2021-03-15");
			ticketsData.get("111").add("2021-03-30");
			ticketsData.get("111").add("EMP12");
			ticketsData.get("111").add("EMP123");
			ticketsData.get("111").add("Tejasw");
			ticketsData.get("111").add("bug");
			ticketsData.get("111").add("1");
			ticketsData.get("111").add("3");
			ticketsData.get("111").add("1");
			
			ticketsData.put("123", new ArrayList<String>());
			ticketsData.get("123").add("develope bugd free login functionality");
			ticketsData.get("123").add("2021-03-15");
			ticketsData.get("123").add("2021-03-30");
			ticketsData.get("123").add("EMP12");
			ticketsData.get("123").add("EMP123");
			ticketsData.get("123").add("Tejasw");
			ticketsData.get("123").add("bug");
			ticketsData.get("123").add("2");
			ticketsData.get("123").add("3");
			ticketsData.get("123").add("2");

		}
		displayUser.printTicketsDetails(ticketsData);
	}
}
