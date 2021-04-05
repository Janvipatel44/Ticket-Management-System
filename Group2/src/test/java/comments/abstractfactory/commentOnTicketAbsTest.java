package comments.abstractfactory;

import commentOnTicket.interfaces.IcommentOnTicket;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import userinterface.IInputOutputHandler;

public abstract class commentOnTicketAbsTest
{

	public abstract IcheckTicketExists checkticketexistsMock();
	public abstract IdisplayTicket displaytickets(IInputOutputHandler inputoutputhandler);
	public abstract IgetListOfTickets getallticketsMock(IdisplayTicket displaytickets);
	public abstract IcommentOnTicket commentonticketMock();
	
}
