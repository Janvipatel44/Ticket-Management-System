package comments;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import commentOnTicket.interfaces.IdisplayTicket;
import commentOnTicket.interfaces.IgetListOfTickets;

public class getListOfTicketsMock implements IgetListOfTickets
{
	
	private IdisplayTicket displayTicket;
	
	Map<String, ArrayList<String>> ticketsData ;
	List<String> columnOfTable;
	
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
		
		displayTicket.printTicketsDetails(ticketsData,columnOfTable);

	}
	
	private void addColumnsOfTable() {
		columnOfTable.add("ticketId");
		columnOfTable.add("description");
		columnOfTable.add("startDate");
		columnOfTable.add("endDate");
		columnOfTable.add("reporterId");
		columnOfTable.add("employeeId");
		columnOfTable.add("assigneeName");
		columnOfTable.add("ticketType");
		columnOfTable.add("priority");
		columnOfTable.add("urgency");
		
	}	

	

}
