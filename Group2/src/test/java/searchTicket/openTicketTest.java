package searchTicket;

import org.junit.Before;
import org.junit.Test;

import reuseablePackage.interfaces.IopenTicket;
import searchTicket.abstarctfactory.IsearchFactoryTest;
import searchTicket.abstarctfactory.searchFactoryTest;


public class openTicketTest
{
	IsearchFactoryTest  searchfactorytest = searchFactoryTest.instance();
	IopenTicket openticket;
	
	@Before
    public void initialize()
    {
		openticket = searchfactorytest.openticketMock();
    }

	
	@Test
	public void openTicketTest()
	{
		String TicketId = "111";
		openticket.openticket(TicketId);
	}
}
