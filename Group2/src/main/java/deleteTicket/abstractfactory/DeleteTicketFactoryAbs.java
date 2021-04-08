package deleteTicket.abstractfactory;

<<<<<<< HEAD
import database.IConnectionManager;
import deleteTicket.interfaces.IDeleteTicket;
=======
import database.intefaces.IConnectionManager;
import deleteTicket.interfaces.IdeleteTicket;
>>>>>>> 5a2ea7b7154c35580472c415ac24ce2ced02e5a3

public abstract class DeleteTicketFactoryAbs
{
	public abstract IDeleteTicket deleteticket(IConnectionManager IConnectionMng);

}
