package searchTicket;

import org.junit.Test;

import displayTickets.IdisplayTicket;
import displayTickets.displayTicket;
import openTicketOption.IopenTicket;

public class openTicketTest
{
	IdisplayTicket displayUser = new displayTicket();
	IopenTicket openticket = new openTicketMock(displayUser);
	
	@Test
	public void openTicketTest()
	{
		String TicketId = "111";
		openticket.openticket(TicketId);
	}
}
