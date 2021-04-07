package updateTicketDetails.abstractfactory;

import database.IConnectionManager;
import updateTicketDetails.updateTicket;
import updateTicketDetails.interfaces.IticketStatusInProgress;
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


	public IupdateTicket updateTicket(IConnectionManager ConnectionMng,IticketStatusInProgress ticketInProgress) 
	{	
		return new updateTicket(ConnectionMng,ticketInProgress);
	}

}
