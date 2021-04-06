package reuseablePackage.abstractFactory;

import database.IConnectionManager;
import reuseablePackage.TableGenerator;
import reuseablePackage.checkTicketExists;
import reuseablePackage.displayTicket;
import reuseablePackage.getListOfTickets;
import reuseablePackage.openTicket;
import reuseablePackage.storeTicketData;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import reuseablePackage.ticketStatusInProgress;
=======
>>>>>>> c48c17d804db2ea57f0668d832dbf027e1b99721
>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import reuseablePackage.interfaces.IticketStatusInProgress;
=======
>>>>>>> c48c17d804db2ea57f0668d832dbf027e1b99721
>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad

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
	public IdisplayTicket displayUser(ITableGenerator tableFormate)
	{
		return new displayTicket(tableFormate);
=======
<<<<<<< HEAD
	public ITableGenerator tableFormate()
	{
		return new TableGenerator();
>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
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
	
<<<<<<< HEAD
	public ITableGenerator tableFormate()
	{
		return new TableGenerator();
=======
	public IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng)
	{
		return new ticketStatusInProgress(ConnectionMng);
>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
	}
	
}
