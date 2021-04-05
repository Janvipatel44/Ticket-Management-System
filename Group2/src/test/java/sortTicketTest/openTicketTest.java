package sortTicketTest;


import org.junit.Test;

import reuseablePackage.interfaces.IopenTicket;
import sortTicketTest.abstractfactory.ISortTicketFactoryTest;
import sortTicketTest.abstractfactory.SortTicketFactoryTest;

public class openTicketTest
{
	ISortTicketFactoryTest sortticketfactory = SortTicketFactoryTest.instance();
	IopenTicket openticket = sortticketfactory.openticketMock();
	
	@Test
	public void openTicketTest()
	{
		String TicketId = "111";
		openticket.openticket(TicketId);
	}
}
