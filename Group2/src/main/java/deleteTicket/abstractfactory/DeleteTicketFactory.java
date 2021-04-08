package deleteTicket.abstractfactory;

import database.intefaces.IConnectionManager;
import deleteTicket.DeleteTicket;
import deleteTicket.interfaces.IDeleteTicket;

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
