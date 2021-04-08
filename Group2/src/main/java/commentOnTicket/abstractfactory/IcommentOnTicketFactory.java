package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.ICommentOnTicket;
import database.IConnectionManager;

public interface ICommentOnTicketFactory 
{
	ICommentOnTicket postComment(IConnectionManager ConnectionMng);
}
