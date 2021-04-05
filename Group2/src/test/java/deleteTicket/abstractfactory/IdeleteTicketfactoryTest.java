package deleteTicket.abstractfactory;

import deleteTicket.interfaces.IdeleteTicket;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import userinterface.IInputOutputHandler;

public interface IdeleteTicketfactoryTest {

	IcheckTicketExists checkticketexistsMock();
	IInputOutputHandler inputoutputhandler();
	ITableGenerator tablegenerat();
	IdisplayTicket displayuser(ITableGenerator tablegenerat);
	IgetListOfTickets getlistoftickets(IdisplayTicket displayUser);
	IdeleteTicket deleteTicketMock();
}
