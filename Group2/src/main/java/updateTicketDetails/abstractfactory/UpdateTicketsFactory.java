package updateTicketDetails.abstractfactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.UpdateTicket;
import updateTicketDetails.interfaces.IUpdateTicket;


public class UpdateTicketsFactory implements IUpdateTicketFactory
{
	private static IUpdateTicketFactory uniqueInstance = null;

    private UpdateTicketsFactory()
    {

    }

    public static IUpdateTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new UpdateTicketsFactory();
        }
        return uniqueInstance;
    }


	public IUpdateTicket updateTicket(IConnectionManager ConnectionMng,IticketStatusInProgress ticketInProgress) 
	{	
		return new UpdateTicket(ConnectionMng,ticketInProgress);
	}

}
