package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.ICommentOnTicket;
import database.IConnectionManager;

public abstract class CommentOnTicketAbs
{
	public abstract ICommentOnTicket postComment(IConnectionManager ConnectionMng);
}
