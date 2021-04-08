package searchTicket.abstractfactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.ExportTickets;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.SearchTicket;
import searchTicket.interfaces.ISearchTicket;

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

   
	
}

