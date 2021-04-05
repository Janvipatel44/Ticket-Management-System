package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.IConnectionManager;
import commentOnTicket.interfaces.IcommentOnTicket;

public abstract class commentOnTicketAbs
{
	public abstract IcommentOnTicket postComment(IConnectionManager ConnectionMng);
}
