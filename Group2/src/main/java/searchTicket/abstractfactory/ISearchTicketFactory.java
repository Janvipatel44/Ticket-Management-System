package searchTicket.abstractfactory;


import database.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.interfaces.ISearchTicket;

public interface ISearchTicketFactory {

	ISearchTicket searchticket(IStoreTicketData storeTicketData,IDisplayTicket displayuser,IConnectionManager ConnectionMng);
	IExportTicket exportTicketData(IStoreTicketData storeTicketData);
}

