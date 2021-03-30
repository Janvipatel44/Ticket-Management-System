package displayTickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import GenerateTable.TableGenerator;

public class displayTicket implements IdisplayTicket
{
	List<String> tableHeader;
	List<List<String>> rowOfTable;
	TableGenerator tableFormate;

	public void printTicketsDetails(Map<String,ArrayList<String>> ticketData)
	{ 
		tableHeader = new ArrayList<String>();
		rowOfTable = new  ArrayList<>();
		tableFormate = new TableGenerator();
		tableHeader.add("ticketId");
	    tableHeader.add("description");
		
	    for(String key : ticketData.keySet())
		{
			ArrayList<String> rowData = new ArrayList<>();
			rowData.add(key);
			String element = ticketData.get(key).get(0);
			rowData.add(element);
			rowOfTable.add(rowData);
			
			
		}
		
		System.out.println(tableFormate.generateTable(tableHeader,rowOfTable));
	}
	
	public void printSignleTicketDetails(List<String> singleTicketData, List<String> comments)
	{
		tableHeader = new ArrayList<String>();
		rowOfTable = new  ArrayList<>();
		tableFormate = new TableGenerator();
		ArrayList<String> rowData = new ArrayList<>();
		tableHeader.add("ticketId");
		tableHeader.add("description");
		tableHeader.add("startDate");
		tableHeader.add("endDate");
		tableHeader.add("reporterId");
		tableHeader.add("employeeId");
		tableHeader.add("assigneeName");
		tableHeader.add("ticketType");
		tableHeader.add("priority");
		tableHeader.add("urgency");
		tableHeader.add("impact");
		System.out.println(tableHeader);
		for(int i = 0; i < singleTicketData.size(); i++)
		{
			rowData.add(singleTicketData.get(i));
		}
		rowOfTable.add(rowData);
		System.out.print(tableFormate.generateTable(tableHeader,rowOfTable));
		System.out.println("Commets.....");
		for(int i = 0; i < comments.size() ; i++)
		{
			System.out.println("   "+comments.get(i));
		}
	}
}
	
