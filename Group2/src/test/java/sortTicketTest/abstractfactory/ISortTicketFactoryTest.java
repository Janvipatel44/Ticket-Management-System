package sortTicketTest.abstractfactory;

import sortTickets.interfaces.IdisplayTicket;
import sortTickets.interfaces.IopenTicket;
import sortTickets.interfaces.IsortTicketData;

public interface ISortTicketFactoryTest {

	IdisplayTicket displayUser();
	IopenTicket openticketMock();
	IsortTicketData sortTicketMock();
}
