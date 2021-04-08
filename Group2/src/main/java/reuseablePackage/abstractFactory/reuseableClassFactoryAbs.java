package reuseablePackage.abstractFactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import reuseablePackage.interfaces.IticketStatusInProgress;


public abstract class reuseableClassFactoryAbs
{
	public abstract IcheckTicketExists checkticketexists();
	public abstract ITableGenerator tableFormate();
	public abstract IstoreTicketData storeTicketData();

	public abstract IdisplayTicket displayUser(ITableGenerator tableFormate);
	public abstract IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
	public abstract IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
    public abstract IexportTicket exportTicketData(IstoreTicketData storeTicketData);
    public abstract IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);


}
