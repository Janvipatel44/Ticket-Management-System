
package abstarctfactory;

import searchTicket.displayTicket;
import searchTicket.openTicketMock;
import searchTicket.searchTicketMock;
import searchTicket.interfaces.IdisplayTicket;
import searchTicket.interfaces.IopenTicket;
import searchTicket.interfaces.IsearchTicket;

public class searchFactoryTest implements IsearchFactoryTest
{
	private static IsearchFactoryTest uniqueInstance = null;

    private searchFactoryTest()
    {

    }

    public static IsearchFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new searchFactoryTest();
        }
        return uniqueInstance;
    }


	public IopenTicket openticketMock() {
		
		return new openTicketMock();
	}


	public IsearchTicket searchticketMock() {
		
		return new searchTicketMock();
	}


	public IdisplayTicket displayUser() {
		
		return new displayTicket();
	}

   
	
}
