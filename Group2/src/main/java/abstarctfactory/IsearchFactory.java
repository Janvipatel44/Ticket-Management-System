package abstarctfactory;

import searchTicket.interfaces.IConnectionManager;
import searchTicket.interfaces.IdisplayTicket;
import searchTicket.interfaces.IexportTicket;
import searchTicket.interfaces.IopenTicket;
import searchTicket.interfaces.IsearchTicket;
import searchTicket.interfaces.IstoreTicketData;

public interface IsearchFactory {

		IstoreTicketData storeTicketData();
		IdisplayTicket displayUser();
		IConnectionManager ConnectionMng(String ConfigurationFile);
		IsearchTicket searchticket(IstoreTicketData storeTicketData,IConnectionManager ConnectionMng);
		IopenTicket openticket(IstoreTicketData storeTicketData,IConnectionManager ConnectionMng);
		IexportTicket exportTicketData(IstoreTicketData storeTicketData);
}

