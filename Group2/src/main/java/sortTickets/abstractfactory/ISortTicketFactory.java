package sortTickets.abstractfactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.interfaces.IsortTicket;

public interface ISortTicketFactory
{
	IsortTicket sortTicketobj(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
}
