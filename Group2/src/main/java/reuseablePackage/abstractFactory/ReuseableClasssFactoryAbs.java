package reuseablePackage.abstractFactory;

import java.sql.SQLException;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.ITableGenerator;


public abstract class ReuseableClasssFactoryAbs
{
	public abstract ICheckTicketsExists checkticketexists();
	public abstract ITableGenerator tableFormate();
	public abstract IStoreTicketData storeTicketData() throws SQLException;
	public abstract IDisplayTickets displayUser();
	public abstract IGetListOfTickets getalltickets(IConnectionManager connectionManager);
	public abstract IOpenTicket openticket(IConnectionManager connectionManager);
    public abstract IExportTicket exportTicketData(IStoreTicketData storeTicketData);
}
