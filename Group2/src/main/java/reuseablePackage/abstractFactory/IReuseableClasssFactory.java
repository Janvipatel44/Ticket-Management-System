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

public interface IReuseableClasssFactory
{
	IStoreTicketData storeTicketData();
	ITableGenerator tableFormate();
	IDisplayTickets displayUser(ITableGenerator tableFormate);
//	IConnectionManager ConnectionMng( String ConfigurationFile);
//	IInputOutputHandler inputoutputhandler ();
	IOpenTicket openticket(IStoreTicketData storeTicketData,IDisplayTickets displayUser,IConnectionManager ConnectionMng);
	ICheckTicketsExists checkticketexists();
	IGetListOfTickets getalltickets(IStoreTicketData storeTicketData,IDisplayTickets displaytickets,IConnectionManager ConnectionMng);

	public IExportTicket exportTicketData(IStoreTicketData storeTicketData);	

	IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);
	

}
