package reuseablePackage.abstractFactory;

import database.IConnectionManager;
import reuseablePackage.TableGenerator;
import reuseablePackage.checkTicketExists;
import reuseablePackage.displayTicket;
import reuseablePackage.exportTicket;
import reuseablePackage.getListOfTickets;
import reuseablePackage.openTicket;
import reuseablePackage.storeTicketData;
import reuseablePackage.ticketStatusInProgress;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import reuseablePackage.interfaces.IticketStatusInProgress;

public class reuseableClassFactory implements IreuseableClassFactory {

	private static reuseableClassFactory uniqueInstance = null;

    private reuseableClassFactory()
    {

    }

    public static IreuseableClassFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new reuseableClassFactory();
        }
        return uniqueInstance;
    }


	public IstoreTicketData storeTicketData() 
	{
		return new storeTicketData();
	}
		
	public IdisplayTicket displayUser(ITableGenerator tableFormate)
	{
		return new displayTicket(tableFormate);
	}
	

	public ITableGenerator tableFormate()
	{
		return new TableGenerator();

	}

	public IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng)
	{
		return new openTicket(storeTicketData,displayUser,ConnectionMng);
	}


	public IcheckTicketExists checkticketexists()
	{
		return new checkTicketExists();
	}
	

	public IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng)
	{
		return new getListOfTickets(storeTicketData,displaytickets,ConnectionMng);
	}
	

	public IexportTicket exportTicketData(IstoreTicketData storeTicketData) 
	{
		return new exportTicket(storeTicketData);
	}
	
	
	public IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng)
	{
		return new ticketStatusInProgress(ConnectionMng);

	}
	
}
