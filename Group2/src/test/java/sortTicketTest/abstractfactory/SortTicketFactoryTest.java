package sortTicketTest.abstractfactory;

import searchTicket.interfaces.ISortTicket;
import sortTicketTest.SortTicketMock;

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

	public ISortTicket sortTicketMock() 
	{
		return new SortTicketMock();
	}
	
}
