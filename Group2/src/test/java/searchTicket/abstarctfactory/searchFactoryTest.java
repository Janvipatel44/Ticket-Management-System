package searchTicket.abstarctfactory;


import reuseablePackage.displayTicket;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import searchTicket.openTicketMock;
import searchTicket.searchTicketMock;
import searchTicket.interfaces.IsearchTicket;
import userinterface.IInputOutputHandler;

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


	public IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler) {
		
		return new displayTicket(inputoutputhandler);
	}

   
	
}
