package deleteTicket.abstractfactory;

import database.IConnectionManager;
import deleteTicket.interfaces.IdeleteTicket;


public interface IDeleteTicketFactory 
{
	IdeleteTicket deleteticket(IConnectionManager IConnectionMng);

}
