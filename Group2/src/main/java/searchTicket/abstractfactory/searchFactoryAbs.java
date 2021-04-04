package searchTicket.abstractfactory;

import abstarctfactory.IConnectionManager;
import reuseablePackage.interfaces.IstoreTicketData;
import searchTicket.interfaces.IexportTicket;
import searchTicket.interfaces.IsearchTicket;

public abstract class searchTicketFactoryAbs {

	public abstract IsearchTicket searchticket(IstoreTicketData storeTicketData,IConnectionManager ConnectionMng);
	public abstract IexportTicket exportTicketData(IstoreTicketData storeTicketData);
}
