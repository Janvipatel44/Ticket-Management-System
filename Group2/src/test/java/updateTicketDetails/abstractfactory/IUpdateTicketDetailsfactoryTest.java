package updateTicketDetails.abstractfactory;

import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IUpdateTicket;

public interface IUpdateTicketDetailsfactoryTest {

	IticketStatusInProgress ticketInProgressMock();
	IUpdateTicket updateticketMock();
}
