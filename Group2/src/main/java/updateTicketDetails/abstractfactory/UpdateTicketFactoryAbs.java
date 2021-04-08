package updateTicketDetails.abstractfactory;

import database.IConnectionManager;
import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IUpdateTicket;

public abstract class UpdateTicketFactoryAbs
{
	public abstract IUpdateTicket updateTicket(IConnectionManager ConnectionMng,IticketStatusInProgress ticketInProgress);
}
