package abstarctfactory;

import searchTicket.interfaces.IdisplayTicket;
import searchTicket.interfaces.IopenTicket;
import searchTicket.interfaces.IsearchTicket;

public interface IsearchFactoryTest {

	IopenTicket openticketMock();
	IsearchTicket searchticketMock();
	IdisplayTicket displayUser();
}

