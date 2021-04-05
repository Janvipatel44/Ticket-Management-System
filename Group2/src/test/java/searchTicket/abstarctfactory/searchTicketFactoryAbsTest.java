package searchTicket.abstarctfactory;


import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import searchTicket.interfaces.IsearchTicket;
import userinterface.IInputOutputHandler;

public abstract class searchTicketFactoryAbsTest 
{

	public abstract IopenTicket openticketMock();
	public abstract IsearchTicket searchticketMock();
	public abstract IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler);
}
