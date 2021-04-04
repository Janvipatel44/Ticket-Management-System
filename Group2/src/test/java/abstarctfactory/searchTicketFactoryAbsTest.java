package abstarctfactory;

import searchTicket.interfaces.IdisplayTicket;
import searchTicket.interfaces.IopenTicket;
import searchTicket.interfaces.IsearchTicket;

public abstract class searchTicketFactoryAbsTest 
{

	public abstract IopenTicket openticketMock();
	public abstract IsearchTicket searchticketMock();
	public abstract IdisplayTicket displayUser();
}
