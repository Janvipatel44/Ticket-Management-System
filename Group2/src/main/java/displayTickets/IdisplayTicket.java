package displayTickets;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IdisplayTicket 
{
	public void printTicketsDetails(Map<String,ArrayList<String>> ticketData);
	public void printSignleTicketDetails(List<String> singleTicketData,List<String> comments);
}
