package reuseablePackage.abstractFactory;

import database.IConnectionManager;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
import reuseablePackage.interfaces.IticketStatusInProgress;
=======
>>>>>>> c48c17d804db2ea57f0668d832dbf027e1b99721
>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
>>>>>>> e56b2235298b9593bd0c3cef8226877d954e1f08
>>>>>>> c6eefe9a39d31e61d315bfad8c29b0da7afff01d


public interface IreuseableClassFactory
{
	IstoreTicketData storeTicketData();
	ITableGenerator tableFormate();
	IdisplayTicket displayUser(ITableGenerator tableFormate);
//	IConnectionManager ConnectionMng( String ConfigurationFile);
//	IInputOutputHandler inputoutputhandler ();
	IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
	IcheckTicketExists checkticketexists();
	IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
<<<<<<< HEAD
	public IexportTicket exportTicketData(IstoreTicketData storeTicketData);	
=======
	IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);
>>>>>>> c6eefe9a39d31e61d315bfad8c29b0da7afff01d
}
