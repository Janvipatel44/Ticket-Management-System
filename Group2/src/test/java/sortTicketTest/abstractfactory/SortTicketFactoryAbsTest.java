package sortTicketTest.abstractfactory;

import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import sortTickets.interfaces.IsortTicketData;
import userinterface.IInputOutputHandler;

public abstract class SortTicketFactoryAbsTest 
{
	public abstract IInputOutputHandler inputoutputhandler();
	public abstract IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler);
	public abstract IopenTicket openticketMock();
	public abstract IsortTicketData sortTicketMock();
}