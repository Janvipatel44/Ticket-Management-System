package deleteTicket.abstractfactory;

<<<<<<< HEAD
import database.IConnectionManager;
import deleteTicket.DeleteTicket;
import deleteTicket.interfaces.IDeleteTicket;
=======
import database.intefaces.IConnectionManager;
import deleteTicket.deleteTicket;
import deleteTicket.interfaces.IdeleteTicket;
>>>>>>> 5a2ea7b7154c35580472c415ac24ce2ced02e5a3



public class DeleteTicketFactory implements IDeleteTicketFactory
{
	private static IDeleteTicketFactory uniqueInstance = null;

    private DeleteTicketFactory()
    {

    }

    public static IDeleteTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new DeleteTicketFactory();
        }
        return uniqueInstance;
    }


	public IDeleteTicket deleteticket(IConnectionManager IConnectionMng)
	{		
		return new DeleteTicket(IConnectionMng);
	}

}
