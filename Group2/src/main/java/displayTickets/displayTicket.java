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
	
	public displayTicket() 
	{
		tableHeader = new ArrayList<String>();
		rowOfTable = new  ArrayList<>();
		tableFormate = new TableGenerator();
	}
	
	public void printTicketsDetails(Map<String,ArrayList<String>> ticketData)
	{ 
		boolean  result = addRowsValues(ticketData);
		result = addTableAttributes();
		
		System.out.println(tableFormate.generateTable(tableHeader, rowOfTable));
//		System.out.print("\033[31m");
//		System.out.println("+-------------------------TICKET-------------------------+");
//		for(String key : ticketData.keySet()) 
//		{
//			System.out.println("Ticket ID:" + key);
//			System.out.println("................................");
//			for(int i=0 ; i < ticketData.get(key).size() ; i++)
//			{
//				System.out.println(ticketData.get(key).get(i));
//			}
//			System.out.println("................................ \n");
//		}
	}
	
	
	private boolean addRowsValues(Map<String, ArrayList<String>> ticketData) {
		List<String> rowData = new ArrayList<>();
		for(String key : ticketData.keySet())
		{
			rowData.add(key);
			for(int i=0 ; i < ticketData.get(key).size() ; i++)
				{
					rowData.add(ticketData.get(key).get(i));
				}
			rowOfTable.add(rowData);
		}
		return false;
	}

	public void printSignleTicketDetails(List<String> singleTicketData, List<String> comments)
	{
		
		for(int i = 0; i < singleTicketData.size(); i++)
		{
			System.out.println(" "+singleTicketData.get(i));
		}
		System.out.println(" "+ "Comments...");
		for(int i = 0; i < comments.size() ; i++)
		{
			System.out.println("   "+comments.get(i));
		}
	}
    

    private boolean addTableAttributes() 
    {
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
       
       return true;
    }
}
	
