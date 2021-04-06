package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.IcommentOnTicket;
import database.IConnectionManager;

public abstract class commentOnTicketAbs
{
	public abstract IcommentOnTicket postComment(IConnectionManager ConnectionMng);
}
