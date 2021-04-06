package comments;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import reuseableClasses.abstractfactory.IreuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.reuseableClassFactoryTest;
import reuseablePackage.interfaces.IcheckTicketExists;

public class CheckTicketExistsTest 
{
	IreuseableClassesFactoryTest reuseableclassfactorytest = reuseableClassFactoryTest.instance();
	IcheckTicketExists checkticketexists =reuseableclassfactorytest.checkticketexistMock();
	
	@Test
	public void ticketExistsTest()
	{
		assertTrue(checkticketexists.ticketExists("12456"));
		assertFalse(checkticketexists.ticketExists("123"));
	}
}
