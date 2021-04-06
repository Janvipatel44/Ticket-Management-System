package deleteTicket.abstractfactory;

import database.IConnectionManager;
import deleteTicket.interfaces.IdeleteTicket;

public abstract class DeleteTicketFactoryAbs
{
	public abstract IdeleteTicket deleteticket(IConnectionManager IConnectionMng);

}
