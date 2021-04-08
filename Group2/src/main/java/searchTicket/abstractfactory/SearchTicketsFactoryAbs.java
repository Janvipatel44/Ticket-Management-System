package searchTicket.abstractfactory;


import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.interfaces.IExportTicket;
import searchTicket.interfaces.IOpenTicket;
import searchTicket.interfaces.ISearchTicket;

public abstract class SearchTicketsFactoryAbs 
{

	public abstract ISearchTicket searchticket(IStoreTicketData storeTicketData,IDisplayTickets displayuser,IConnectionManager ConnectionMng);
	public abstract IExportTicket exportTicketData(IStoreTicketData storeTicketData);
	public abstract IOpenTicket openticket(IStoreTicketData storeTicketData,IDisplayTickets displayUser,IConnectionManager ConnectionMng);
	public abstract IStoreTicketData storeTicketData();
}
