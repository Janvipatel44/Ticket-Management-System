package sortTickets.abstractfactory;

<<<<<<< HEAD
import database.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.SortTicket;
import sortTickets.interfaces.ISortTicket;
=======
import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.sortTicket;
import sortTickets.interfaces.IsortTicket;
>>>>>>> 5a2ea7b7154c35580472c415ac24ce2ced02e5a3

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


	
	public ISortTicket sortTicketobj(IStoreTicketData storeTicketData,IDisplayTicket displayUser,IConnectionManager ConnectionMng)
	{
		return new SortTicket(storeTicketData,displayUser,ConnectionMng);
	}
	
}
