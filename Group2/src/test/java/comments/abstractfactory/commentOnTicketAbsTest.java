package comments.abstractfactory;

import commentOnTicket.interfaces.IcheckTicketExists;
import commentOnTicket.interfaces.IcommentOnTicket;
import commentOnTicket.interfaces.IdisplayTicket;
import commentOnTicket.interfaces.IgetListOfTickets;

public abstract class commentOnTicketAbsTest
{

	public abstract IcheckTicketExists checkticketexistsMock();
	public abstract IdisplayTicket displaytickets();
	public abstract IgetListOfTickets getallticketsMock(IdisplayTicket displaytickets);
	public abstract IcommentOnTicket commentonticketMock();
	
}
