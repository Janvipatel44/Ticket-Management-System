package reuseablePackage.abstractFactory;

import reuseablePackage.displayTicket;
import reuseablePackage.openTicket;
import reuseablePackage.storeTicketData;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.ConnectionManager;
import sortTickets.InputOutputHandler;
import sortTickets.interfaces.IConnectionManager;
import sortTickets.interfaces.IInputOutputHandler;

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
	
	public IConnectionManager ConnectionMng( String ConfigurationFile)
	{
		return new ConnectionManager(ConfigurationFile);
	}
	
	public IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng)
	{
		return new openTicket(storeTicketData,displayUser,ConnectionMng);
	}

	public IInputOutputHandler inputoutputhandler() {
		
		return new InputOutputHandler();
	}
}
