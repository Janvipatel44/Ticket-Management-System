
package abstarctfactory;


import searchTicket.ConnectionManager;
import searchTicket.displayTicket;
import searchTicket.exportTicket;
import searchTicket.openTicket;
import searchTicket.searchTicket;
import searchTicket.storeTicketData;
import searchTicket.interfaces.IConnectionManager;
import searchTicket.interfaces.IdisplayTicket;
import searchTicket.interfaces.IexportTicket;
import searchTicket.interfaces.IopenTicket;
import searchTicket.interfaces.IsearchTicket;
import searchTicket.interfaces.IstoreTicketData;

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

	
	public IstoreTicketData storeTicketData() {
		
		return new storeTicketData();
	}

	
	public IdisplayTicket displayUser() {
		
		return new displayTicket();
	}


	public IConnectionManager ConnectionMng(String ConfigurationFile) {
		
		return new ConnectionManager(ConfigurationFile);
	}

	
	public IsearchTicket searchticket(IstoreTicketData storeTicketData, IConnectionManager ConnectionMng) {
		
		return new searchTicket(storeTicketData,ConnectionMng);
	}

	
	public IopenTicket openticket(IstoreTicketData storeTicketData, IConnectionManager ConnectionMng) {
		
		return new openTicket(storeTicketData,ConnectionMng);
	}

	
	public IexportTicket exportTicketData(IstoreTicketData storeTicketData) 
	{
		return new exportTicket(storeTicketData);
	}

   
	
}
