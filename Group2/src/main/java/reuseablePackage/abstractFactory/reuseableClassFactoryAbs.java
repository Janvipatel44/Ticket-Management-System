package reuseablePackage.abstractFactory;

import database.IConnectionManager;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
import reuseablePackage.TableGenerator;
=======
>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
>>>>>>> e56b2235298b9593bd0c3cef8226877d954e1f08
>>>>>>> c6eefe9a39d31e61d315bfad8c29b0da7afff01d
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
import userinterface.IInputOutputHandler;
=======
>>>>>>> c48c17d804db2ea57f0668d832dbf027e1b99721
>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
>>>>>>> e56b2235298b9593bd0c3cef8226877d954e1f08
>>>>>>> c6eefe9a39d31e61d315bfad8c29b0da7afff01d

public abstract class reuseableClassFactoryAbs
{
	public abstract IcheckTicketExists checkticketexists();
	public abstract ITableGenerator tableFormate();
	public abstract IstoreTicketData storeTicketData();
<<<<<<< HEAD
	public abstract IdisplayTicket displayUser(ITableGenerator tableFormate);
	public abstract IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
	public abstract IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
    public abstract IexportTicket exportTicketData(IstoreTicketData storeTicketData);
=======
<<<<<<< HEAD
	public abstract ITableGenerator tableFormate();
	public abstract IdisplayTicket displayUser(ITableGenerator tableFormate);
=======
<<<<<<< HEAD
	public abstract IdisplayTicket displayUser(TableGenerator tableFormate);
>>>>>>> e56b2235298b9593bd0c3cef8226877d954e1f08
	public abstract IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
	public abstract IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
	public abstract ITableGenerator tableFormate();
=======
	public abstract ITableGenerator tableFormate();
	public abstract IdisplayTicket displayUser(ITableGenerator tableFormate);
	public abstract IgetListOfTickets getalltickets(IstoreTicketData storeTicketData,IdisplayTicket displaytickets,IConnectionManager ConnectionMng);
	public abstract IopenTicket openticket(IstoreTicketData storeTicketData,IdisplayTicket displayUser,IConnectionManager ConnectionMng);
	public abstract IticketStatusInProgress ticketInProgress(IConnectionManager ConnectionMng);

>>>>>>> 0f49392a7257876e081394bca39199e2863e18ad
>>>>>>> c6eefe9a39d31e61d315bfad8c29b0da7afff01d
}
