package updateTicketDetails.abstractfactory;

import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IupdateTicket;

public abstract class updateTicketDetailsfactoryAbsTest {
	public abstract IcheckTicketExists checkticketexistsMock();
	public abstract IticketStatusInProgress ticketInProgressMock();
	public abstract IupdateTicket updateticketMock();
}
