package openTicketOption;

import displayTickets.IdisplayTicket;
import displayTickets.displayTicket;

public class openTicket implements IopenTicket
{
	private IdisplayTicket callObj=new displayTicket();
	
	public void openTicket(String ticketID) 
	{
		callObj.openTicket(ticketID);
	}

}
