package searchTicket.abstractfactory;


import reuseablePackage.interfaces.IstoreTicketData;
import searchTicket.interfaces.IexportTicket;
import searchTicket.interfaces.IsearchTicket;

public interface IsearchFactory {

	IsearchTicket searchticket(IstoreTicketData storeTicketData,IConnectionManager ConnectionMng);
	IexportTicket exportTicketData(IstoreTicketData storeTicketData);
}

