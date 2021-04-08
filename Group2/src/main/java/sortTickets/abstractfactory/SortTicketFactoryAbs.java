package sortTickets.abstractfactory;

<<<<<<< HEAD
import database.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.interfaces.ISortTicket;
=======
import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.interfaces.IsortTicket;
>>>>>>> 5a2ea7b7154c35580472c415ac24ce2ced02e5a3

public abstract class SortTicketFactoryAbs 
{
	public abstract ISortTicket sortTicketobj(IStoreTicketData storeTicketData,IDisplayTicket displayUser,IConnectionManager ConnectionMng);
}
