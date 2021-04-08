package updateTicketDetails.abstractfactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IupdateTicket;

public interface IupdateTicketFactory 
{
	IupdateTicket updateTicket(IConnectionManager ConnectionMng,IticketStatusInProgress ticketInProgress);
}
