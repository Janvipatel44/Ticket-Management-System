package sortTickets.abstractfactory;


import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.interfaces.ISortTicket;


public abstract class SortTicketFactoryAbs 
{
	public abstract ISortTicket sortTicketobj(IStoreTicketData storeTicketData,IDisplayTicket displayUser,IConnectionManager ConnectionMng);
}
