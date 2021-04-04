package searchTicket.abstractfactory;

import reuseablePackage.interfaces.IstoreTicketData;
import searchTicket.exportTicket;
import searchTicket.searchTicket;
import searchTicket.interfaces.IexportTicket;
import searchTicket.interfaces.IsearchTicket;

public class searchFactory implements IsearchFactory
{
	private static IsearchFactory uniqueInstance = null;

    private searchFactory()
    {

    }

    public static IsearchFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new searchFactory();
        }
        return uniqueInstance;
    }

	

	
	public IsearchTicket searchticket(IstoreTicketData storeTicketData, IConnectionManager ConnectionMng) {
		
		return new searchTicket(storeTicketData,ConnectionMng);
	}

	
	public IexportTicket exportTicketData(IstoreTicketData storeTicketData) 
	{
		return new exportTicket(storeTicketData);
	}

   
	
}

