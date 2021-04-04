package updateTicketDetails.abstractfactory;

import updateTicketDetails.interfaces.IdeleteTicket;
import updateTicketDetails.interfaces.IupdateTicket;

public abstract class updateTicketFactoryAbs
{
	public abstract IdeleteTicket deleteticket();
	public abstract IupdateTicket updateTicket();
}
