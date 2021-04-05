package comments.abstractfactory;

import commentOnTicket.interfaces.IcommentOnTicket;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import userinterface.IInputOutputHandler;

public interface IcommentOnTicketFactoryTest 
{
	IcheckTicketExists checkticketexistsMock();
	IdisplayTicket displaytickets(IInputOutputHandler inputoutputhandler);
	IgetListOfTickets getallticketsMock(IdisplayTicket displaytickets);
	IcommentOnTicket commentonticketMock();
	
}
