package deleteTicket.abstractfactory;

import database.intefaces.IConnectionManager;
import deleteTicket.interfaces.IdeleteTicket;

public abstract class DeleteTicketFactoryAbs
{
	public abstract IdeleteTicket deleteticket(IConnectionManager IConnectionMng);

}
