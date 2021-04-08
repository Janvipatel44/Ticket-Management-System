package updateTicketDetails.abstractfactory;

import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IUpdateTicket;

public abstract class UpdateTicketDetailsfactoryAbsTest {
	public abstract IticketStatusInProgress ticketInProgressMock();
	public abstract IUpdateTicket updateticketMock();
}
