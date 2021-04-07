package searchTicket;

import org.junit.Test;

import reuseableClasses.abstractfactory.IreuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.reuseableClassFactoryTest;
import reuseablePackage.interfaces.IopenTicket;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;


public class openTicketTest
{
	private IreuseableClassesFactoryTest reuseableclassfactory = reuseableClassFactoryTest.instance();
	IopenTicket openticket = reuseableclassfactory.openticketMock();
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();
//	 
//	@Before
//    public void initialize()
//    {
//		openticket = searchfactorytest.openticketMock();
//    }
//
//	
	@Test
	public void openTicketTest()
	{
		String TicketId = "111";
		String output = openticket.openticket(TicketId);
		inputoutputhandler.displayMethod(output);
	}
}
