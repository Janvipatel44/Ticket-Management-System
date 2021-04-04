package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.IConnectionManager;
import commentOnTicket.interfaces.IcheckTicketExists;
import commentOnTicket.interfaces.IcommentOnTicket;
import commentOnTicket.interfaces.IdisplayTicket;
import commentOnTicket.interfaces.IgetListOfTickets;
import commentOnTicket.interfaces.IstoreTicketData;

public abstract class commentOnTicketAbs
{

	public abstract IcheckTicketExists checkticketexists();
	public abstract IConnectionManager ConnectionMng(String ConfigurationFile);
	public abstract IstoreTicketData storeTicketData();
	public abstract IdisplayTicket displaytickets();
	public abstract IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
	public abstract IcommentOnTicket postComment(IConnectionManager ConnectionMng);
}
