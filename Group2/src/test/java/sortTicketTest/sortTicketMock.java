package sortTicketTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import sortTicketTest.abstractfactory.ISortTicketFactoryTest;
import sortTicketTest.abstractfactory.SortTicketFactoryTest;
import sortTickets.interfaces.IdisplayTicket;
import sortTickets.interfaces.IsortTicketData;

public class sortTicketMock implements IsortTicketData
{
	Map<String, ArrayList<String>> ticketsData ;
	List<String> columnOfTable;
	
	ISortTicketFactoryTest sortticketfactory = SortTicketFactoryTest.instance();
	IdisplayTicket displayuser;
	
	
	public sortTicketMock()
	{
		displayuser = sortticketfactory.displayUser();
		ticketsData = new LinkedHashMap<String, ArrayList<String>>();
		columnOfTable = new ArrayList<String>();
	}
	
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
		displayuser.printTicketsDetails(ticketsData,columnOfTable);
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
