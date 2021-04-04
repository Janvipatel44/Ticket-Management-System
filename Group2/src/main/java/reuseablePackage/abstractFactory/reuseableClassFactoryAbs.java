package reuseablePackage.abstractFactory;

import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.interfaces.IConnectionManager;
import sortTickets.interfaces.IInputOutputHandler;

public abstract class reuseableClassFactoryAbs
{
	public abstract IcheckTicketExists checkticketexists();
	public abstract IstoreTicketData storeTicketData();
	public abstract IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler);
	public abstract IConnectionManager ConnectionMng( String ConfigurationFile);
	public abstract IInputOutputHandler inputoutputhandler ();
	public abstract IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
	public abstract IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);

}
