package searchTicket.abstractfactory;


import database.IConnectionManager;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import searchTicket.interfaces.IsearchTicket;

public abstract class searchTicketFactoryAbs 
{

	public abstract IsearchTicket searchticket(IstoreTicketData storeTicketData,IdisplayTicket displayuser,IConnectionManager ConnectionMng);
	public abstract IexportTicket exportTicketData(IstoreTicketData storeTicketData);
}
