package reuseablePackage.abstractFactory;

import database.IConnectionManager;
import reuseablePackage.TableGenerator;
import reuseablePackage.CheckTicketExists;
import reuseablePackage.DisplayTicket;
import reuseablePackage.ExportTicket;
import reuseablePackage.GetListOfTickets;
import reuseablePackage.OpenTicket;
import reuseablePackage.StoreTicketData;
import reuseablePackage.ticketStatusInProgress;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.ICheckTicketExists;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.IticketStatusInProgress;

public class ReuseableClassFactory implements IReuseableClassFactory {

	private static ReuseableClassFactory uniqueInstance = null;

    private ReuseableClassFactory()
    {

    }

    public static IReuseableClassFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new ReuseableClassFactory();
        }
        return uniqueInstance;
    }


	public IStoreTicketData storeTicketData() 
	{
		return new StoreTicketData();
	}
		
	public IDisplayTicket displayUser(ITableGenerator tableFormate)
	{
		return new DisplayTicket(tableFormate);
	}
	

	public ITableGenerator tableFormate()
	{
		return new TableGenerator();

	}

	public IOpenTicket openticket(IStoreTicketData storeTicketData,IDisplayTicket displayUser,IConnectionManager ConnectionMng)
	{
		return new OpenTicket(storeTicketData,displayUser,ConnectionMng);
	}


	public ICheckTicketExists checkticketexists()
	{
		return new CheckTicketExists();
	}
	

	public IGetListOfTickets getalltickets(IStoreTicketData storeTicketData,IDisplayTicket displaytickets,IConnectionManager ConnectionMng)
	{
		return new GetListOfTickets(storeTicketData,displaytickets,ConnectionMng);
	}
	

	public IExportTicket exportTicketData(IStoreTicketData storeTicketData) 
	{
		return new ExportTicket(storeTicketData);
	}
	
	
	public IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng)
	{
		return new ticketStatusInProgress(ConnectionMng);

	}
	
}
