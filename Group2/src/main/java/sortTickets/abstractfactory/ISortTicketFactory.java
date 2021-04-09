package sortTickets.abstractfactory;

import database.intefaces.IConnectionManager;
import sortTickets.interfaces.ISortTicket;

public interface ISortTicketFactory
{
	ISortTicket sortTicketobj(IConnectionManager connectionManager);
}
