package sortTicketTest.abstractfactory;

import reuseablePackage.displayTicket;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import sortTicketTest.openTicketMock;
import sortTicketTest.sortTicketMock;
import sortTickets.InputOutputHandler;
import sortTickets.interfaces.IInputOutputHandler;
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

   public IInputOutputHandler inputoutputhandler()
   {
	   return new InputOutputHandler();
   }
	public IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler)
	{
		return new displayTicket(inputoutputhandler);
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
