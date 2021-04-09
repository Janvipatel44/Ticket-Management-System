package sortTickets.abstractfactory;


import database.intefaces.IConnectionManager;
import sortTickets.interfaces.ISortTicket;


public abstract class SortTicketFactoryAbs 
{
	public abstract ISortTicket sortTicketobj(IConnectionManager connectionManager);
}
