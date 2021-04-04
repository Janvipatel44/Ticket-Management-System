package sortTickets.abstractfactory;

import sortTickets.ConnectionManager;
import sortTickets.displayTicket;
import sortTickets.openTicket;
import sortTickets.sortTicket;
import sortTickets.storeTicketData;
import sortTickets.interfaces.IConnectionManager;
import sortTickets.interfaces.IdisplayTicket;
import sortTickets.interfaces.IopenTicket;
import sortTickets.interfaces.IsortTicketData;
import sortTickets.interfaces.IstoreTicketData;

public class SortTicketFactory implements ISortTicketFactory
{

	private static ISortTicketFactory uniqueInstance = null;

    private SortTicketFactory()
    {

    }

    public static ISortTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new SortTicketFactory();
        }
        return uniqueInstance;
    }


	public IstoreTicketData storeTicketData() 
	{
		return new storeTicketData();
	}
	public IdisplayTicket displayUser()
	{
		return new displayTicket();
	}
	public IConnectionManager ConnectionMng( String ConfigurationFile)
	{
		return new ConnectionManager(ConfigurationFile);
	}
	public IsortTicketData sortTicketobj(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng)
	{
		return new sortTicket(storeTicketData,displayUser,ConnectionMng);
	}
	public IopenTicket openticket(IstoreTicketData storeTicketData,IConnectionManager ConnectionMng)
	{
		return new openTicket(storeTicketData,ConnectionMng);
	}
}
