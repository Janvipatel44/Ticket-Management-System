package reuseablePackage.abstractFactory;

import database.IConnectionManager;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import updateTicketDetails.interfaces.IticketStatusInProgress;

public interface IreuseableClassFactory
{
	IstoreTicketData storeTicketData();
	ITableGenerator tableFormate();
	IdisplayTicket displayUser(ITableGenerator tableFormate);
//	IConnectionManager ConnectionMng( String ConfigurationFile);
//	IInputOutputHandler inputoutputhandler ();
	IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
	IcheckTicketExists checkticketexists();
	IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);

	public IexportTicket exportTicketData(IstoreTicketData storeTicketData);	

	IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);

}
