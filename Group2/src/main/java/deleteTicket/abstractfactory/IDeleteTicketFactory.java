package deleteTicket.abstractfactory;

import database.IConnectionManager;
import deleteTicket.interfaces.IDeleteTicket;


public interface IDeleteTicketFactory 
{
	IDeleteTicket deleteticket(IConnectionManager IConnectionMng);

}
