package reuseableClasses;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;

public class getListOfTicketsMock implements IgetListOfTickets
{
	private IreuseableClassFactory reuseableclassfactory = reuseableClassFactory.instance();
	private ITableGenerator generateTable;
	private IdisplayTicket displayticket;
	
	Map<String, ArrayList<String>> ticketsData ;
	List<String> columnOfTable;
	
	public getListOfTicketsMock()
	{
		generateTable = reuseableclassfactory.tableFormate() ;
		displayticket =reuseableclassfactory.displayUser(generateTable);
		ticketsData = new LinkedHashMap<String, ArrayList<String>>();
		columnOfTable = new ArrayList<String>();
	}
	
	public String listOfTickets() 
	{
		addColumnsOfTable();
		
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
		
		
		String output = displayticket.printTicketsDetails(ticketsData,columnOfTable);
		return output;
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
