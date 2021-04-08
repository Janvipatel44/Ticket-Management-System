package sortTickets.abstractfactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.interfaces.ISortTicket;

public interface ISortTicketFactory
{
	ISortTicket sortTicketobj(IStoreTicketData storeTicketData,IDisplayTickets displayUser,IConnectionManager ConnectionMng);
}
