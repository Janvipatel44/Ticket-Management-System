package commentOnTicket.abstractfactory;

import commentOnTicket.CommentOnTicket;
import commentOnTicket.interfaces.ICommentOnTicket;
import database.intefaces.IConnectionManager;

public class CommentOnTicketFactory implements ICommentOnTicketFactory
{
	private static CommentOnTicketFactory uniqueInstance = null;

    private CommentOnTicketFactory()
    {

    }

    public static ICommentOnTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new CommentOnTicketFactory();
        }
        return uniqueInstance;
    }

	public ICommentOnTicket postComment(IConnectionManager ConnectionMng)
	{
		return new CommentOnTicket(ConnectionMng);
	}

}
