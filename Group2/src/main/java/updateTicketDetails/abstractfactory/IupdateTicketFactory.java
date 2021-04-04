package updateTicketDetails.abstractfactory;

import updateTicketDetails.interfaces.IdeleteTicket;
import updateTicketDetails.interfaces.IupdateTicket;

public interface IupdateTicketFactory 
{
	IdeleteTicket deleteticket();
	IupdateTicket updateTicket();
}
