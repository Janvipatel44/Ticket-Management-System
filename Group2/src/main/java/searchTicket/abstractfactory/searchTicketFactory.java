package searchTicket.abstractfactory;

import database.IConnectionManager;
import reuseablePackage.exportTicket;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import searchTicket.searchTicket;
import searchTicket.interfaces.IsearchTicket;

public class searchTicketFactory implements IsearchTicketFactory
{
	private static IsearchTicketFactory uniqueInstance = null;

    private searchTicketFactory()
    {

    }

    public static IsearchTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new searchTicketFactory();
        }
        return uniqueInstance;
    }

	

	
	public IsearchTicket searchticket(IstoreTicketData storeTicketData,IdisplayTicket displayuser,IConnectionManager ConnectionMng) {
		
		return new searchTicket(storeTicketData,displayuser,ConnectionMng);
	}

	
	public IexportTicket exportTicketData(IstoreTicketData storeTicketData) 
	{
		return new exportTicket(storeTicketData);
	}

   
	
}

