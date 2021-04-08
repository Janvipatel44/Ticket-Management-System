package deleteTicket.abstractfactory;

import database.intefaces.IConnectionManager;
import deleteTicket.interfaces.IdeleteTicket;


public interface IDeleteTicketFactory 
{
	IdeleteTicket deleteticket(IConnectionManager IConnectionMng);

}
