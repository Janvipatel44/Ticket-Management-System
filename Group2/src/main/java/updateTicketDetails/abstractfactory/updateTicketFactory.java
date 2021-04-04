package updateTicketDetails.abstractfactory;

import updateTicketDetails.deleteTicket;
import updateTicketDetails.updateTicket;
import updateTicketDetails.interfaces.IdeleteTicket;
import updateTicketDetails.interfaces.IupdateTicket;


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


	public IdeleteTicket deleteticket()
	{		
		return new deleteTicket();
	}

	public IupdateTicket updateTicket() 
	{	
		return new updateTicket();
	}

}
