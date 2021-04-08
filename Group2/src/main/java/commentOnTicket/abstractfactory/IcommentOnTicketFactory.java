package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.ICommentOnTicket;
import database.intefaces.IConnectionManager;

public interface ICommentOnTicketFactory 
{
	ICommentOnTicket postComment(IConnectionManager ConnectionMng);
}
