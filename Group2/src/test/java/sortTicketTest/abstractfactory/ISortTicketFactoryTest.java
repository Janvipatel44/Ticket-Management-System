package sortTicketTest.abstractfactory;

import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import sortTickets.interfaces.IInputOutputHandler;
import sortTickets.interfaces.IsortTicketData;

public interface ISortTicketFactoryTest {

	IInputOutputHandler inputoutputhandler();
	IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler);
	IopenTicket openticketMock();
	IsortTicketData sortTicketMock();
}
