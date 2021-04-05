package searchTicket;

import org.junit.Before;
import org.junit.Test;

import searchTicket.abstarctfactory.IsearchFactoryTest;
import searchTicket.abstarctfactory.searchFactoryTest;
import searchTicket.interfaces.IsearchTicket;


public class searchTicketTest 
{
	IsearchFactoryTest  searchfactorytest = searchFactoryTest.instance();
	IsearchTicket searchticket;
	
	@Before
    public void initialize()
    {
		searchticket = searchfactorytest.searchticketMock();
    }

	
	@Test
	public void searchbyTicketIDTest()
	{
		String TicketId = "111";
		searchticket.searchbyTicket(1, TicketId);
	}
	
	@Test
	public void searchbyTicketAssigneeTest()
	{
		String AssigneeName = "Tejasw";
		searchticket.searchbyTicket(2, AssigneeName);
	}
	
	@Test
	public void searchbyTicketTypeTest()
	{
		String TicketType = "bug";
		searchticket.searchbyTicket(3, TicketType);
	}
	
	@Test
	public void searchAllTicketTest()
	{
		String TicketIAll = null;
		searchticket.searchbyTicket(4, TicketIAll);
	}
	
	@Test
	public void searchbyTicketCreatorTest()
	{
		String TicketCreatorId= "EMP123";
		searchticket.searchbyTicket(5, TicketCreatorId);
	}
	
	@Test
	public void searchTicketbyKeyWordTest()
	{
		String keyword = "login";
		searchticket.searchbyTicket(6, keyword);
	}
	
}
