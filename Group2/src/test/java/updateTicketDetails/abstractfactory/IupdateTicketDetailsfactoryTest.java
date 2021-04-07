package updateTicketDetails.abstractfactory;

import updateTicketDetails.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IupdateTicket;

public interface IupdateTicketDetailsfactoryTest {

	IticketStatusInProgress ticketInProgressMock();
	IupdateTicket updateticketMock();
}
