package deleteTicket.abstractfactory;

import database.IConnectionManager;
import deleteTicket.interfaces.IDeleteTicket;

public abstract class DeleteTicketFactoryAbs
{
	public abstract IDeleteTicket deleteticket(IConnectionManager IConnectionMng);

}
