package reuseablePackage.abstractFactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IticketStatusInProgress;


public abstract class ReuseableClasssFactoryAbs
{
	public abstract ICheckTicketsExists checkticketexists();
	public abstract ITableGenerator tableFormate();
	public abstract IStoreTicketData storeTicketData();

	public abstract IDisplayTickets displayUser(ITableGenerator tableFormate);
	public abstract IGetListOfTickets getalltickets(IStoreTicketData storeTicketData,IDisplayTickets displaytickets,IConnectionManager ConnectionMng);
	public abstract IOpenTicket openticket(IStoreTicketData storeTicketData,IDisplayTickets displayUser,IConnectionManager ConnectionMng);
    public abstract IExportTicket exportTicketData(IStoreTicketData storeTicketData);
    public abstract IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);


}
