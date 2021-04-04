package reuseablePackage.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IdisplayTicket 
{
	public void printTicketsDetails(Map<String,ArrayList<String>> ticketData, List<String> columnsOfTable);
	public void printSignleTicketDetails(List<String> singleTicketData,List<String> columnsOfTable,List<String> comments);

}
