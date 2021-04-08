package searchTicket.abstractfactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.ExportTickets;
import searchTicket.OpenTickets;
import searchTicket.SearchTicket;
import searchTicket.SortTicket;
import searchTicket.interfaces.IExportTicket;
import searchTicket.interfaces.IOpenTicket;
import searchTicket.interfaces.ISearchTicket;
import searchTicket.interfaces.ISortTicket;

public class SearchTicketsFactory implements ISearchTicketsFactory
{
	private static ISearchTicketsFactory uniqueInstance = null;

    private SearchTicketsFactory()
    {

    }

    public static ISearchTicketsFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new SearchTicketsFactory();
        }
        return uniqueInstance;
    }

	

	
	public ISearchTicket searchticket(IStoreTicketData storeTicketData,IDisplayTickets displayuser,IConnectionManager ConnectionMng) {
		
		return new SearchTicket(storeTicketData,displayuser,ConnectionMng);
	}

	
	public IExportTicket exportTicketData(IStoreTicketData storeTicketData) 
	{
		return new ExportTickets(storeTicketData);
	}

	public IOpenTicket openticket(IStoreTicketData storeTicketData,IDisplayTickets displayUser,IConnectionManager ConnectionMng)
	{
		return new OpenTickets(storeTicketData,displayUser,ConnectionMng);
	}

	public ISortTicket sortTicketobj(IStoreTicketData storeTicketData, IDisplayTickets displayUser)
	{
		return new SortTicket(storeTicketData,displayUser);
	}
	
	
   
	
}

