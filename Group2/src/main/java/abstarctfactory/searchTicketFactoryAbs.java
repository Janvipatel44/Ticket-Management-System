package abstarctfactory;

import searchTicket.interfaces.IConnectionManager;
import searchTicket.interfaces.IdisplayTicket;
import searchTicket.interfaces.IexportTicket;
import searchTicket.interfaces.IopenTicket;
import searchTicket.interfaces.IsearchTicket;
import searchTicket.interfaces.IstoreTicketData;

public abstract class searchTicketFactoryAbs {

	public abstract IstoreTicketData storeTicketData();
	public abstract IdisplayTicket displayUser();
	public abstract IConnectionManager ConnectionMng(String ConfigurationFile);
	public abstract IsearchTicket searchticket(IstoreTicketData storeTicketData,IConnectionManager ConnectionMng);
	public abstract IopenTicket openticket(IstoreTicketData storeTicketData,IConnectionManager ConnectionMng);
	public abstract IexportTicket exportTicketData(IstoreTicketData storeTicketData);
}
