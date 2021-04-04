package comments.abstractfactory;

import commentOnTicket.interfaces.IcommentOnTicket;
import commentOnTicket.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IgetListOfTickets;

public interface IcommentOnTicketFactoryTest 
{
	IcheckTicketExists checkticketexistsMock();
	IdisplayTicket displaytickets();
	IgetListOfTickets getallticketsMock(IdisplayTicket displaytickets);
	IcommentOnTicket commentonticketMock();
	
}
