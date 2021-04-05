package searchTicket.abstarctfactory;

import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import searchTicket.interfaces.IsearchTicket;
import userinterface.IInputOutputHandler;

public interface IsearchFactoryTest {

	IopenTicket openticketMock();
	IsearchTicket searchticketMock();
	IdisplayTicket displayUser(IInputOutputHandler inputoutputhandler);
}

