package searchTicket.abstractfactory;


import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.interfaces.IExportTicket;
import searchTicket.interfaces.IOpenTicket;
import searchTicket.interfaces.ISearchTicket;
import searchTicket.interfaces.ISortTicket;

public interface ISearchTicketsFactory {

	ISearchTicket searchticket(IStoreTicketData storeTicketData,IDisplayTickets displayuser,IConnectionManager ConnectionMng);
	IExportTicket exportTicketData(IStoreTicketData storeTicketData);
	IOpenTicket openticket(IStoreTicketData storeTicketData,IDisplayTickets displayUser,IConnectionManager ConnectionMng);
	ISortTicket sortTicketobj(IStoreTicketData storeTicketData,IDisplayTickets displayUser);
	
}

