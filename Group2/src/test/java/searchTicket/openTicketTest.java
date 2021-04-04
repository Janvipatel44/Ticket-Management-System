package searchTicket;

import org.junit.Before;
import org.junit.Test;

import abstarctfactory.IsearchFactoryTest;
import abstarctfactory.searchFactoryTest;
import searchTicket.interfaces.IopenTicket;

public class openTicketTest
{
	IsearchFactoryTest  searchfactorytest =   searchFactoryTest.instance();
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
