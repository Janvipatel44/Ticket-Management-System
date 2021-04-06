package reuseablePackage.abstractFactory;

import database.IConnectionManager;
import reuseablePackage.TableGenerator;
import reuseablePackage.checkTicketExists;
import reuseablePackage.displayTicket;
import reuseablePackage.getListOfTickets;
import reuseablePackage.openTicket;
import reuseablePackage.storeTicketData;
<<<<<<< HEAD
import reuseablePackage.ticketStatusInProgress;
=======
>>>>>>> c48c17d804db2ea57f0668d832dbf027e1b99721
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
<<<<<<< HEAD
import reuseablePackage.interfaces.IticketStatusInProgress;
=======
>>>>>>> c48c17d804db2ea57f0668d832dbf027e1b99721

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
	
<<<<<<< HEAD
	public ITableGenerator tableFormate()
	{
		return new TableGenerator();
	}

	public IdisplayTicket displayUser(ITableGenerator tableFormate)
	{
		return new displayTicket(tableFormate);
=======
	public IdisplayTicket displayUser(ITableGenerator tableFormate)
	{
		return new displayTicket(tableFormate);
	}

	public ITableGenerator tableFormate()
	{
		return new TableGenerator();
>>>>>>> c48c17d804db2ea57f0668d832dbf027e1b99721
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
	
	public IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng)
	{
		return new ticketStatusInProgress(ConnectionMng);
	}
	
}
