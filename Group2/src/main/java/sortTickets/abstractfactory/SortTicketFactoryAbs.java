package sortTickets.abstractfactory;

import sortTickets.interfaces.IConnectionManager;
import sortTickets.interfaces.IdisplayTicket;
import sortTickets.interfaces.IopenTicket;
import sortTickets.interfaces.IsortTicketData;
import sortTickets.interfaces.IstoreTicketData;

public abstract class SortTicketFactoryAbs 
{
	public abstract IstoreTicketData storeTicketData();
	public abstract IdisplayTicket displayUser();
	public abstract IConnectionManager ConnectionMng( String ConfigurationFile);
	public abstract IsortTicketData sortTicketobj(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
	public abstract IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);

}
