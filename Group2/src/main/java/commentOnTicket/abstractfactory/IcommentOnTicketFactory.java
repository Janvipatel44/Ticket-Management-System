package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.IConnectionManager;
import commentOnTicket.interfaces.IcommentOnTicket;

public interface IcommentOnTicketFactory 
{
	IcommentOnTicket postComment(IConnectionManager ConnectionMng);
}
