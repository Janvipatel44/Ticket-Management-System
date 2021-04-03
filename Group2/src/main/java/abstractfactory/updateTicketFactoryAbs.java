package abstractfactory;

import interfacs.IcheckTicketExists;
import interfacs.IdeleteTicket;
import interfacs.IgetListOfTickets;
import interfacs.IupdateTicket;

public abstract class updateTicketFactoryAbs
{
	public abstract IcheckTicketExists getcheckticketexists();
	public abstract IgetListOfTickets getalltickets();
	public abstract IdeleteTicket deleteticket();
	public abstract IupdateTicket updateTicket();
}
