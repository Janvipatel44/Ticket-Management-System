package deleteTicket.abstractfactory;


import database.intefaces.IConnectionManager;
import deleteTicket.interfaces.IDeleteTicket;


public abstract class DeleteTicketFactoryAbs
{
	public abstract IDeleteTicket deleteticket(IConnectionManager IConnectionMng);

}
