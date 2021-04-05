package updateTicketDetails.abstractfactory;

import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IupdateTicket;

public interface IupdateTicketDetailsfactoryTest {

	IcheckTicketExists checkticketexistsMock();
	IticketStatusInProgress ticketInProgressMock();
	IupdateTicket updateticketMock();
}
