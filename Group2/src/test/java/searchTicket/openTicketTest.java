package searchTicket;

import org.junit.Test;

import openTicketOption.IopenTicket;

public class openTicketTest
{
	IopenTicket openticket = new openTicketMock();
	
	@Test
	public void openTicketTest()
	{
		String TicketId = "111";
		openticket.openticket(TicketId);
	}
}
