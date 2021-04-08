package searchTicket.abstractfactory;


import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.interfaces.ISearchTicket;

public abstract class SearchTicketFactoryAbs 
{

	public abstract ISearchTicket searchticket(IStoreTicketData storeTicketData,IDisplayTicket displayuser,IConnectionManager ConnectionMng);
	public abstract IExportTicket exportTicketData(IStoreTicketData storeTicketData);
}
