package reuseablePackage.abstractFactory;

import reuseablePackage.interfaces.IdisplayTicket;
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
}
