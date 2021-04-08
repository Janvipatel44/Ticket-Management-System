package reuseablePackage.abstractFactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.ICheckTicketExists;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IticketStatusInProgress;

public interface IReuseableClassFactory
{
	IStoreTicketData storeTicketData();
	ITableGenerator tableFormate();
	IDisplayTicket displayUser(ITableGenerator tableFormate);
//	IConnectionManager ConnectionMng( String ConfigurationFile);
//	IInputOutputHandler inputoutputhandler ();
	IOpenTicket openticket(IStoreTicketData storeTicketData,IDisplayTicket displayUser,IConnectionManager ConnectionMng);
	ICheckTicketExists checkticketexists();
	IGetListOfTickets getalltickets(IStoreTicketData storeTicketData,IDisplayTicket displaytickets,IConnectionManager ConnectionMng);

	public IExportTicket exportTicketData(IStoreTicketData storeTicketData);	

	IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);

}
