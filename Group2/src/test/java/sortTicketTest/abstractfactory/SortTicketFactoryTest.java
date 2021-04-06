package sortTicketTest.abstractfactory;

import sortTicketTest.sortTicketMock;
import sortTickets.interfaces.IsortTicket;

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

	public IsortTicket sortTicketMock() 
	{
		return new sortTicketMock();
	}
	
}
