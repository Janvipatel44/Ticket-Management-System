package searchTicket;

import org.junit.Before;
import org.junit.Test;

import searchTicket.abstarctfactory.IsearchFactoryTest;
import searchTicket.abstarctfactory.searchFactoryTest;
import searchTicket.interfaces.IsearchTicket;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;


public class searchTicketTest 
{
	IsearchFactoryTest  searchfactorytest = searchFactoryTest.instance();
	IsearchTicket searchticket;
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();
	
	@Before
    public void initialize()
    {
		searchticket = searchfactorytest.searchticketMock();
    }

	
	@Test
	public void searchbyTicketIDTest()
	{
		String TicketId = "111";
		String output = searchticket.searchbyTicket(1, TicketId);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void searchbyTicketAssigneeTest()
	{
		String AssigneeName = "Tejasw";
		String output = searchticket.searchbyTicket(2, AssigneeName);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void searchbyTicketTypeTest()
	{
		String TicketType = "bug";
		String output = searchticket.searchbyTicket(3, TicketType);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void searchAllTicketTest()
	{
		String TicketIAll = null;
		String output = searchticket.searchbyTicket(4, TicketIAll);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void searchbyTicketCreatorTest()
	{
		String TicketCreatorId= "EMP123";
		String output = searchticket.searchbyTicket(5, TicketCreatorId);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void searchTicketbyKeyWordTest()
	{
		String keyword = "login";
		String output = searchticket.searchbyTicket(6, keyword);
		inputoutputhandler.displayMethod(output);
	}
	
}
