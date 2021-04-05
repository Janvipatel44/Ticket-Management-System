package deleteTicket.abstractfactory;

import deleteTicket.interfaces.IdeleteTicket;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import userinterface.IInputOutputHandler;

public abstract class deleteTicketfactoryTestAbs {

	public abstract IcheckTicketExists checkticketexistsMock();
	public abstract IInputOutputHandler inputoutputhandler();
	public abstract ITableGenerator tablegenerat();
	public abstract IdisplayTicket displayuser(ITableGenerator tablegenerat);
	public abstract IgetListOfTickets getlistoftickets(IdisplayTicket displayUser);
	public abstract IdeleteTicket deleteTicketMock();

}
