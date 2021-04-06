package reuseablePackage.abstractFactory;

import database.IConnectionManager;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
<<<<<<< HEAD
import reuseablePackage.interfaces.IticketStatusInProgress;
import userinterface.IInputOutputHandler;
=======
>>>>>>> c48c17d804db2ea57f0668d832dbf027e1b99721

public abstract class reuseableClassFactoryAbs
{
	public abstract IcheckTicketExists checkticketexists();
	public abstract IstoreTicketData storeTicketData();
	public abstract ITableGenerator tableFormate();
	public abstract IdisplayTicket displayUser(ITableGenerator tableFormate);
	public abstract IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
	public abstract IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
	public abstract IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);

}
