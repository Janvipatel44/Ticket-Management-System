package sortTicketTest;


import org.junit.Test;

import reuseableClasses.abstractfactory.IreuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.reuseableClassFactoryTest;
import reuseablePackage.interfaces.IopenTicket;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class openTicketTest
{
	IreuseableClassesFactoryTest reuseableclassfactorytest = reuseableClassFactoryTest.instance();
	IopenTicket openticket = reuseableclassfactorytest.openticketMock();
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();
	
	@Test
	public void openTicketTest()
	{
		String TicketId = "111";
		String output = openticket.openticket(TicketId);
		inputoutputhandler.displayMethod(output);
	}
}
