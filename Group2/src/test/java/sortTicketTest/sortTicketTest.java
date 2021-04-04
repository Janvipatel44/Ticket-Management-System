package sortTicketTest;

import org.junit.Test;

import sortTicketTest.abstractfactory.ISortTicketFactoryTest;
import sortTicketTest.abstractfactory.SortTicketFactoryTest;
import sortTickets.interfaces.IsortTicketData;

public class sortTicketTest 
{
	ISortTicketFactoryTest sortticketfactory = SortTicketFactoryTest.instance();
	IsortTicketData sortTicket = sortticketfactory.sortTicketMock();
	
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
