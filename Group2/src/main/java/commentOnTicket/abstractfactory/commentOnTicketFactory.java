package commentOnTicket.abstractfactory;

import commentOnTicket.commentOnTicket;
import commentOnTicket.interfaces.IConnectionManager;
import commentOnTicket.interfaces.IcommentOnTicket;

public class commentOnTicketFactory implements IcommentOnTicketFactory
{
	private static commentOnTicketFactory uniqueInstance = null;

    private commentOnTicketFactory()
    {

    }

    public static IcommentOnTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new commentOnTicketFactory();
        }
        return uniqueInstance;
    }

	public IcommentOnTicket postComment(IConnectionManager ConnectionMng)
	{
		return new commentOnTicket(ConnectionMng);
	}

}
