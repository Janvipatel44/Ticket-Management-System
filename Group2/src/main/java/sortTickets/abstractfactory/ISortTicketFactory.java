package sortTickets.abstractfactory;

import sortTickets.interfaces.IConnectionManager;
import sortTickets.interfaces.IdisplayTicket;
import sortTickets.interfaces.IopenTicket;
import sortTickets.interfaces.IsortTicketData;
import sortTickets.interfaces.IstoreTicketData;

public interface ISortTicketFactory {

	IstoreTicketData storeTicketData();
	IdisplayTicket displayUser();
	IConnectionManager ConnectionMng( String ConfigurationFile);
	IsortTicketData sortTicketobj(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
	IopenTicket openticket(IstoreTicketData storeTicketData,IConnectionManager ConnectionMng);
	
}
