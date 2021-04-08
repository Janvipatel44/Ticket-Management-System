package sortTicketTest;

import searchTicket.interfaces.ISortTicket;
import sortTicketTest.abstractfactory.ISortTicketFactoryTest;
import sortTicketTest.abstractfactory.SortTicketFactoryTest;
import userinterface.IInputOutputHandler;

public class SortTicketTest 
{
	IInputOutputHandler inputoutputhandler;
	ISortTicketFactoryTest sortticketfactory = SortTicketFactoryTest.instance();
	ISortTicket sortTicket = sortticketfactory.sortTicketMock();
	
//	@Test
//	public void sortByPriority()
//	{
//		int choice = 1;
//		sortTicket.sortTickets(choice);
//	}
//	
//	@Test
//	public void sortByUrgency()
//	{
//		int choice = 2;
//		sortTicket.sortTickets(choice);
//	}
//	
//	@Test
//	public void sortByImpact()
//	{
//		int choice = 3;
//		sortTicket.sortTickets(choice);
//	}
	
}
