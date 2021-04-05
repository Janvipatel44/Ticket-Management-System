package updateTicketDetails.abstractfactory;

import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IupdateTicket;

public interface IupdateTicketDetailsfactoryTest {

	IticketStatusInProgress ticketInProgressMock();
	IupdateTicket updateticketMock();
}
