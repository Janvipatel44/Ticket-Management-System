package comments.abstractfactory;

import commentOnTicket.displayTicket;
import commentOnTicket.interfaces.IcommentOnTicket;
import commentOnTicket.interfaces.IdisplayTicket;
import comments.CheckTicketExistsMock;
import comments.commentOnTicketMock;
import comments.getListOfTicketsMock;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IgetListOfTickets;

public class commentOnTicketFactoryTest implements IcommentOnTicketFactoryTest
{
	private static commentOnTicketFactoryTest uniqueInstance = null;

    private commentOnTicketFactoryTest()
    {

    }

    public static IcommentOnTicketFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new commentOnTicketFactoryTest();
        }
        return uniqueInstance;
    }


	public IcheckTicketExists checkticketexistsMock()
	{
		return new CheckTicketExistsMock();
	}
	public IdisplayTicket displaytickets()
	{
		return new displayTicket();
	}
	public IgetListOfTickets getallticketsMock(IdisplayTicket displaytickets)
	{
		return new getListOfTicketsMock(displaytickets);
	}
	public IcommentOnTicket commentonticketMock()
	{
		return new commentOnTicketMock();
	}
	
}
