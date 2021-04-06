package searchTicket.abstarctfactory;


import searchTicket.searchTicketMock;
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


	public IsearchTicket searchticketMock() 
	{
		
		return new searchTicketMock();
	}


   
	
}
