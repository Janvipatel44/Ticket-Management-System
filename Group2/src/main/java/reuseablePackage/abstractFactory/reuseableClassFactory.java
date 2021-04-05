package reuseablePackage.abstractFactory;

import database.IConnectionManager;
import reuseablePackage.checkTicketExists;
import reuseablePackage.displayTicket;
import reuseablePackage.exportTicket;
import reuseablePackage.getListOfTickets;
import reuseablePackage.openTicket;
import reuseablePackage.storeTicketData;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import userinterface.IInputOutputHandler;

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
	
	public IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler)
	{
		return new displayTicket(inputoutputhandler);
	}
	
	public IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng)
	{
		return new openTicket(storeTicketData,displayUser,ConnectionMng);
	}

//	public IInputOutputHandler inputoutputhandler() {
//		
//		return new InputOutputHandler();
//	}
//	
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
	
}
