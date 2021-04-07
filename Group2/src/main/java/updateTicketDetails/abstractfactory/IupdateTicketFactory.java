package updateTicketDetails.abstractfactory;

import database.IConnectionManager;
import updateTicketDetails.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IupdateTicket;

public interface IupdateTicketFactory 
{
	IupdateTicket updateTicket(IConnectionManager ConnectionMng,IticketStatusInProgress ticketInProgress);
}
