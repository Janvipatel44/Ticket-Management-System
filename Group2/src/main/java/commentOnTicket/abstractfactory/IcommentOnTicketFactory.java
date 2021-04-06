package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.IcommentOnTicket;
import database.IConnectionManager;

public interface IcommentOnTicketFactory 
{
	IcommentOnTicket postComment(IConnectionManager ConnectionMng);
}
