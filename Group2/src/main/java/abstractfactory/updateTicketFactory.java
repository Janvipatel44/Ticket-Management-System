package abstractfactory;

import interfacs.IcheckTicketExists;
import interfacs.IdeleteTicket;
import interfacs.IgetListOfTickets;
import interfacs.IupdateTicket;
import updateTicketDetails.checkTicketExists;
import updateTicketDetails.deleteTicket;
import updateTicketDetails.getListOfTickets;
import updateTicketDetails.updateTicket;


public class updateTicketFactory implements IupdateTicketFactory
{
	private static IupdateTicketFactory uniqueInstance = null;

    private updateTicketFactory()
    {

    }

    public static IupdateTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new updateTicketFactory();
        }
        return uniqueInstance;
    }



	public IcheckTicketExists getcheckticketexists()
	{	
		return new checkTicketExists();
	}

	
	public IgetListOfTickets getalltickets() 
	{
		return new getListOfTickets();
	}

	public IdeleteTicket deleteticket()
	{		
		return new deleteTicket();
	}

	public IupdateTicket updateTicket() 
	{	
		return new updateTicket();
	}

}
