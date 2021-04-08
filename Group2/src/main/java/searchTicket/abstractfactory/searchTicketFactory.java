package searchTicket.abstractfactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.ExportTicket;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.SearchTicket;
import searchTicket.interfaces.ISearchTicket;

public class SearchTicketFactory implements ISearchTicketFactory
{
	private static ISearchTicketFactory uniqueInstance = null;

    private SearchTicketFactory()
    {

    }

    public static ISearchTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new SearchTicketFactory();
        }
        return uniqueInstance;
    }

	

	
	public ISearchTicket searchticket(IStoreTicketData storeTicketData,IDisplayTicket displayuser,IConnectionManager ConnectionMng) {
		
		return new SearchTicket(storeTicketData,displayuser,ConnectionMng);
	}

	
	public IExportTicket exportTicketData(IStoreTicketData storeTicketData) 
	{
		return new ExportTicket(storeTicketData);
	}

   
	
}

