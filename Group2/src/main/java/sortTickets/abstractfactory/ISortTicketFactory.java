package sortTickets.abstractfactory;

import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.interfaces.IConnectionManager;
import sortTickets.interfaces.IsortTicketData;

public interface ISortTicketFactory
{
	IsortTicketData sortTicketobj(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
}
