package updateTicketDetails.abstractfactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IUpdateTicket;

public abstract class UpdateTicketFactoryAbs
{
	public abstract IUpdateTicket updateTicket(IConnectionManager ConnectionMng,IticketStatusInProgress ticketInProgress);
}
