package sortTicketTest.abstractfactory;

import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import sortTickets.interfaces.IsortTicketData;
import userinterface.IInputOutputHandler;

public interface ISortTicketFactoryTest {

	IInputOutputHandler inputoutputhandler();
	IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler);
	IopenTicket openticketMock();
	IsortTicketData sortTicketMock();
}
