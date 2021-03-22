package displayTickets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class displayTicket implements IdisplayTicket
{
	
	public void printTicketsDetails(Map<String,ArrayList<String>> ticketData)
	{ 
		System.out.println("..............TICKET..............");
		for(String key : ticketData.keySet()) 
		{
			System.out.println("Ticket ID:" + key);
			System.out.println("................................");
			for(int i=0 ; i < ticketData.get(key).size() ; i++)
			{
				System.out.println(ticketData.get(key).get(i));
			}
			System.out.println("................................ \n");
		}
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

}
	
