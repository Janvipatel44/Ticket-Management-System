package sortTickets.abstractfactory;

import database.IConnectionManager;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.interfaces.IsortTicketData;

public abstract class SortTicketFactoryAbs 
{
	public abstract IsortTicketData sortTicketobj(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
}
