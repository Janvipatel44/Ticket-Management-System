package reuseablePackage.abstractFactory;

import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.interfaces.IConnectionManager;
import sortTickets.interfaces.IInputOutputHandler;

public interface IreuseableClassFactory
{
	IstoreTicketData storeTicketData();
	IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler);
	IConnectionManager ConnectionMng( String ConfigurationFile);
	IInputOutputHandler inputoutputhandler ();
	IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
	IcheckTicketExists checkticketexists();
	IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
		
}
