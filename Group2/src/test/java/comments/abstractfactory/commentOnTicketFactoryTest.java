package comments.abstractfactory;

import commentOnTicket.interfaces.IcommentOnTicket;
import comments.CheckTicketExistsMock;
import comments.commentOnTicketMock;
import comments.getListOfTicketsMock;
import reuseablePackage.displayTicket;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import userinterface.IInputOutputHandler;

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
	public IdisplayTicket displaytickets(IInputOutputHandler inputoutputhandler)
	{
		return new displayTicket(inputoutputhandler);
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
