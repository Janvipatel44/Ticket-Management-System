package comments.abstractfactory;

import commentOnTicket.interfaces.IcheckTicketExists;
import commentOnTicket.interfaces.IcommentOnTicket;
import commentOnTicket.interfaces.IdisplayTicket;
import commentOnTicket.interfaces.IgetListOfTickets;

public interface IcommentOnTicketFactoryTest 
{
	IcheckTicketExists checkticketexistsMock();
	IdisplayTicket displaytickets();
	IgetListOfTickets getallticketsMock(IdisplayTicket displaytickets);
	IcommentOnTicket commentonticketMock();
	
}
