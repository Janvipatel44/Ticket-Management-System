package deleteTicket.abstractfactory;

import database.intefaces.IConnectionManager;
import deleteTicket.deleteTicket;
import deleteTicket.interfaces.IdeleteTicket;



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


	public IdeleteTicket deleteticket(IConnectionManager IConnectionMng)
	{		
		return new deleteTicket(IConnectionMng);
	}

}
