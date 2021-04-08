package reuseablePackage.abstractFactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IticketStatusInProgress;

public interface IReuseableClasssFactory
{
	IStoreTicketData storeTicketData();
	ITableGenerator tableFormate();
	IDisplayTickets displayUser(ITableGenerator tableFormate);
	ICheckTicketsExists checkticketexists();
	IGetListOfTickets getalltickets(IStoreTicketData storeTicketData,IDisplayTickets displaytickets,IConnectionManager ConnectionMng);
	IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);
	

}
