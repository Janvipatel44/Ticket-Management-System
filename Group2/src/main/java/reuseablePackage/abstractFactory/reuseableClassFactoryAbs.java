package reuseablePackage.abstractFactory;

import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.interfaces.IConnectionManager;
import sortTickets.interfaces.IInputOutputHandler;

public abstract class reuseableClassFactoryAbs
{
	public abstract IstoreTicketData storeTicketData();
	public abstract IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler);
	public abstract IConnectionManager ConnectionMng( String ConfigurationFile);
	public abstract IInputOutputHandler inputoutputhandler ();
	public abstract IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);

}
