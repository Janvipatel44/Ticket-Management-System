package reuseablePackage.abstractFactory;

import database.IConnectionManager;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.ICheckTicketExists;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.IticketStatusInProgress;


public abstract class ReuseableClassFactoryAbs
{
	public abstract ICheckTicketExists checkticketexists();
	public abstract ITableGenerator tableFormate();
	public abstract IStoreTicketData storeTicketData();

	public abstract IDisplayTicket displayUser(ITableGenerator tableFormate);
	public abstract IGetListOfTickets getalltickets(IStoreTicketData storeTicketData,IDisplayTicket displaytickets,IConnectionManager ConnectionMng);
	public abstract IOpenTicket openticket(IStoreTicketData storeTicketData,IDisplayTicket displayUser,IConnectionManager ConnectionMng);
    public abstract IExportTicket exportTicketData(IStoreTicketData storeTicketData);
    public abstract IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);


}
