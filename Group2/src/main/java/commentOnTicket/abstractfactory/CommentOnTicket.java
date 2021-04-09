package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.ICommentOnTickets;
import database.intefaces.IConnectionManager;

public abstract class CommentOnTicket
{
	public abstract ICommentOnTickets postComment(IConnectionManager connectionManager);
}
