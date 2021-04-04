package sortTicketTest.abstractfactory;

import sortTicketTest.openTicketMock;
import sortTicketTest.sortTicketMock;
import sortTickets.displayTicket;
import sortTickets.interfaces.IdisplayTicket;
import sortTickets.interfaces.IopenTicket;
import sortTickets.interfaces.IsortTicketData;

public class SortTicketFactoryTest implements ISortTicketFactoryTest
{

	private static ISortTicketFactoryTest uniqueInstance = null;

    private SortTicketFactoryTest()
    {

    }

    public static ISortTicketFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new SortTicketFactoryTest();
        }
        return uniqueInstance;
    }

   
	public IdisplayTicket displayUser()
	{
		return new displayTicket();
	}
	
	public IopenTicket openticketMock() 
	{
		return new openTicketMock();
	}
	
	public IsortTicketData sortTicketMock() 
	{
		return new sortTicketMock();
	}
	
}
