package deleteTicket.abstractfactory;

import database.intefaces.IConnectionManager;
import deleteTicket.interfaces.IDeleteTicket;


public interface IDeleteTicketFactory 
{
	IDeleteTicket deleteticket(IConnectionManager IConnectionMng);

}
