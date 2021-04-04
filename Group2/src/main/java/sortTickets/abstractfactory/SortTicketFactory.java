package sortTickets.abstractfactory;

import database.IConnectionManager;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.sortTicket;
import sortTickets.interfaces.IsortTicketData;

public class SortTicketFactory implements ISortTicketFactory
{

	private static ISortTicketFactory uniqueInstance = null;

    private SortTicketFactory()
    {

    }

    public static ISortTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new SortTicketFactory();
        }
        return uniqueInstance;
    }


	
	public IsortTicketData sortTicketobj(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng)
	{
		return new sortTicket(storeTicketData,displayUser,ConnectionMng);
	}
	
}
