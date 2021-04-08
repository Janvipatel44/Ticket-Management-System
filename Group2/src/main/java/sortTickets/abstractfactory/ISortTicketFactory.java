package sortTickets.abstractfactory;

import database.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.interfaces.ISortTicket;

public interface ISortTicketFactory
{
	ISortTicket sortTicketobj(IStoreTicketData storeTicketData,IDisplayTicket displayUser,IConnectionManager ConnectionMng);
}
