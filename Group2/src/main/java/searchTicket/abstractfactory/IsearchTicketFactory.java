package searchTicket.abstractfactory;


import database.IConnectionManager;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import searchTicket.interfaces.IsearchTicket;

public interface IsearchTicketFactory {

	IsearchTicket searchticket(IstoreTicketData storeTicketData,IdisplayTicket displayuser,IConnectionManager ConnectionMng);
	IexportTicket exportTicketData(IstoreTicketData storeTicketData);
}

