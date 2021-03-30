package comments;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import displayTickets.IdisplayTicket;
import getListOfTickets.IgetListOfTickets;

public class getListOfTicketsMock implements IgetListOfTickets
{
	
	private IdisplayTicket displayTicket;
	Map<String, ArrayList<String>> ticketsData ;
	public getListOfTicketsMock(IdisplayTicket displayUser)
	{
		this.displayTicket = displayUser;
		ticketsData = new LinkedHashMap<String, ArrayList<String>>();
	}
	
	public void listOfTickets() 
	{
		
		ticketsData.put("111", new ArrayList<String>());
		ticketsData.get("111").add(" develope bugd free login functionality");
		ticketsData.get("111").add("2021-03-15");
		ticketsData.get("111").add("2021-03-30");
		ticketsData.get("111").add("EMP12");
		ticketsData.get("111").add("EMP123");
		ticketsData.get("111").add("Tejasw");
		ticketsData.get("111").add(" bug");
		ticketsData.get("111").add("1");
		ticketsData.get("111").add("3");
		ticketsData.get("111").add("3");
		ticketsData.get("111").add("3");
		displayTicket.printTicketsDetails(ticketsData);

	}
	

}
