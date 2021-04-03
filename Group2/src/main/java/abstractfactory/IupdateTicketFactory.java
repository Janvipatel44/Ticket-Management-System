package abstractfactory;

import interfacs.IcheckTicketExists;
import interfacs.IdeleteTicket;
import interfacs.IgetListOfTickets;
import interfacs.IupdateTicket;

public interface IupdateTicketFactory 
{
	IcheckTicketExists getcheckticketexists();
	IgetListOfTickets getalltickets();
	IdeleteTicket deleteticket();
	IupdateTicket updateTicket();
}
