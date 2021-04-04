package sortTicketTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.IdisplayTicket;
import sortTickets.interfaces.IInputOutputHandler;
import sortTickets.interfaces.IsortTicketData;

public class sortTicketMock implements IsortTicketData
{
	Map<String, ArrayList<String>> ticketsData ;
	List<String> columnOfTable;
	
	static IreuseableClassFactory resuableclassfactore = reuseableClassFactory.instance();
	IInputOutputHandler inputoutputhandler;
	IdisplayTicket displayuser;
	
	
	public sortTicketMock()
	{
		inputoutputhandler = resuableclassfactore.inputoutputhandler();
		displayuser = resuableclassfactore.displayUser(inputoutputhandler);
		ticketsData = new LinkedHashMap<String, ArrayList<String>>();
		columnOfTable = new ArrayList<String>();
	}
	
	public void sortTickets(int choice)
	{
		addColumnsOfTable();
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
