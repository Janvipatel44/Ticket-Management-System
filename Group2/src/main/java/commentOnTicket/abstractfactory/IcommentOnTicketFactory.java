package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.IConnectionManager;
import commentOnTicket.interfaces.IcheckTicketExists;
import commentOnTicket.interfaces.IcommentOnTicket;
import commentOnTicket.interfaces.IdisplayTicket;
import commentOnTicket.interfaces.IgetListOfTickets;
import commentOnTicket.interfaces.IstoreTicketData;

public interface IcommentOnTicketFactory 
{

	IcheckTicketExists checkticketexists();
	IConnectionManager ConnectionMng(String ConfigurationFile);
	IstoreTicketData storeTicketData();
	IdisplayTicket displaytickets();
	IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
	IcommentOnTicket postComment(IConnectionManager ConnectionMng);
}
