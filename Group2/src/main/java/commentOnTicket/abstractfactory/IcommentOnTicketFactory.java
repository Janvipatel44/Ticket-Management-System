package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.IcommentOnTicket;
import database.intefaces.IConnectionManager;

public interface IcommentOnTicketFactory 
{
	IcommentOnTicket postComment(IConnectionManager ConnectionMng);
}
