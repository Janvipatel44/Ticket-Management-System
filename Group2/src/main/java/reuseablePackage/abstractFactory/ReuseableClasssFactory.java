package reuseablePackage.abstractFactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.CheckTicketsExists;
import reuseablePackage.DisplayTickets;
import reuseablePackage.ExportTickets;
import reuseablePackage.GetListOfAllTickets;
import reuseablePackage.OpenTickets;
import reuseablePackage.StoreTicketsData;
import reuseablePackage.TableGenerator;
import reuseablePackage.ticketStatusInProgress;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IticketStatusInProgress;

public class ReuseableClasssFactory implements IReuseableClasssFactory {

	private static ReuseableClasssFactory uniqueInstance = null;

    private ReuseableClasssFactory()
    {

    }

    public static IReuseableClasssFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new ReuseableClasssFactory();
        }
        return uniqueInstance;
    }


	public IStoreTicketData storeTicketData()
	{
		return new StoreTicketsData();
	}
		
	public IDisplayTickets displayUser(ITableGenerator tableFormate)
	{
		return new DisplayTickets(tableFormate);
	}
	

	public ITableGenerator tableFormate()
	{
		return new TableGenerator();

	}

	public IOpenTicket openticket(IStoreTicketData storeTicketData,IDisplayTickets displayUser,IConnectionManager ConnectionMng)
	{
		return new OpenTickets(storeTicketData,displayUser,ConnectionMng);
	}


	public ICheckTicketsExists checkticketexists()
	{
		return new CheckTicketsExists();
	}
	

	public IGetListOfTickets getalltickets(IStoreTicketData storeTicketData,IDisplayTickets displaytickets,IConnectionManager ConnectionMng)
	{
		return new GetListOfAllTickets(storeTicketData,displaytickets,ConnectionMng);
	}
	

	public IExportTicket exportTicketData(IStoreTicketData storeTicketData) 
	{
		return new ExportTickets(storeTicketData);
	}
	
	
	public IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng)
	{
		return new ticketStatusInProgress(ConnectionMng);

	}

}
