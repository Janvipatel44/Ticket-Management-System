package sortTicketTest;

import org.junit.Test;

import displayTickets.IdisplayTicket;
import displayTickets.displayTicket;
import sortTickets.IsortTicket;

public class sortTicketTest 
{
	IdisplayTicket displayUser = new displayTicket();
	IsortTicket sortTicket = new sortTicketMock(displayUser);
	
	@Test
	public void sortByPriority()
	{
		int choice = 1;
		sortTicket.sortTickets(choice);
	}
	
	@Test
	public void sortByUrgency()
	{
		int choice = 2;
		sortTicket.sortTickets(choice);
	}
	
	@Test
	public void sortByImpact()
	{
		int choice = 3;
		sortTicket.sortTickets(choice);
	}
	
}
