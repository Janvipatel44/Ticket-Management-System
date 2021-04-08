package updateTicketDetails.abstractfactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.UpdateTicket;
import updateTicketDetails.interfaces.IUpdateTicket;


public class UpdateTicketFactory implements IUpdateTicketFactory
{
	private static IUpdateTicketFactory uniqueInstance = null;

    private UpdateTicketFactory()
    {

    }

    public static IUpdateTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new UpdateTicketFactory();
        }
        return uniqueInstance;
    }


	public IUpdateTicket updateTicket(IConnectionManager ConnectionMng,IticketStatusInProgress ticketInProgress) 
	{	
		return new UpdateTicket(ConnectionMng,ticketInProgress);
	}

}
