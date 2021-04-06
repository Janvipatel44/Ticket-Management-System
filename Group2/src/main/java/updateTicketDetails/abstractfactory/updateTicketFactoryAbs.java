package updateTicketDetails.abstractfactory;

import database.IConnectionManager;
import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IupdateTicket;

public abstract class updateTicketFactoryAbs
{
	public abstract IupdateTicket updateTicket(IConnectionManager ConnectionMng,IticketStatusInProgress ticketInProgress);
}
