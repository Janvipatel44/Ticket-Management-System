package updateTicketDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import interfacs.IdisplayTicket;

public class displayTicket implements IdisplayTicket
{
	List<String> tableHeader;
	List<List<String>> rowOfTable;
	TableGenerator tableFormate;
	
	public displayTicket() 
	{
		tableHeader = new ArrayList<String>();
		rowOfTable = new  ArrayList<>();
		tableFormate = new TableGenerator();
	}
	
	public void printTicketsDetails(Map<String,ArrayList<String>> ticketData,List<String> columnsOfTable)
	{ 
		int indexForTicketID = columnsOfTable.indexOf("ticketID");
		int indexForTicketDescription = columnsOfTable.indexOf("description");
		int indexForTicketStatus = columnsOfTable.indexOf("ticketStatus");
		tableHeader.add(columnsOfTable.get(indexForTicketID));
		tableHeader.add(columnsOfTable.get(indexForTicketDescription));
		tableHeader.add(columnsOfTable.get(indexForTicketStatus));
		for(String key : ticketData.keySet())
		{
			ArrayList<String> rowData = new ArrayList<>();
			rowData.add(key);
			String element = ticketData.get(key).get(indexForTicketDescription-1);
			rowData.add(element);
			element = ticketData.get(key).get(indexForTicketStatus-1);
			rowData.add(element);
			rowOfTable.add(rowData);
			
			
		}

		System.out.println(tableFormate.generateTable(tableHeader, rowOfTable));
	}
	
	
	public void printSignleTicketDetails(List<String> singleTicketData,List<String> columnsOfTable, List<String> comments)
	{
		tableHeader = columnsOfTable;
		rowOfTable.add(singleTicketData);
		System.out.println(tableFormate.generateTable(tableHeader, rowOfTable));
		System.out.println(" "+ "Comments...");
		for(int i = 0; i < comments.size() ; i++)
		{
			System.out.println("   "+comments.get(i));
		}
	}
}
	
