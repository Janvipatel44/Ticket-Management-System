package commentOnTicket.abstractfactory;

import commentOnTicket.ConnectionManager;
import commentOnTicket.checkTicketExists;
import commentOnTicket.commentOnTicket;
import commentOnTicket.displayTicket;
import commentOnTicket.getListOfTickets;
import commentOnTicket.storeTicketData;
import commentOnTicket.interfaces.IConnectionManager;
import commentOnTicket.interfaces.IcheckTicketExists;
import commentOnTicket.interfaces.IcommentOnTicket;
import commentOnTicket.interfaces.IdisplayTicket;
import commentOnTicket.interfaces.IgetListOfTickets;
import commentOnTicket.interfaces.IstoreTicketData;

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

	public IcheckTicketExists checkticketexists()
	{
		return new checkTicketExists();
	}
	public IConnectionManager ConnectionMng(String ConfigurationFile)
	{
		return new ConnectionManager(ConfigurationFile);
	}
	public IstoreTicketData storeTicketData()
	{
		return new storeTicketData();
	}
	public IdisplayTicket displaytickets()
	{
		return new displayTicket();
	}
	public IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng)
	{
		return new getListOfTickets(storeTicketData,displaytickets,ConnectionMng);
	}
	public IcommentOnTicket postComment(IConnectionManager ConnectionMng)
	{
		return new commentOnTicket(ConnectionMng);
	}

}
