package reuseablePackage.abstractFactory;

import database.IConnectionManager;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import reuseablePackage.interfaces.IticketStatusInProgress;
import userinterface.IInputOutputHandler;


public interface IreuseableClassFactory
{
	IstoreTicketData storeTicketData();
	IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler);
//	IConnectionManager ConnectionMng( String ConfigurationFile);
//	IInputOutputHandler inputoutputhandler ();
	IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
	IcheckTicketExists checkticketexists();
	IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
	IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);
}
