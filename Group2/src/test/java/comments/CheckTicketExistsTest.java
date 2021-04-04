package comments;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import comments.abstractfactory.IcommentOnTicketFactoryTest;
import comments.abstractfactory.commentOnTicketFactoryTest;
import reuseablePackage.interfaces.IcheckTicketExists;

public class CheckTicketExistsTest 
{
	IcommentOnTicketFactoryTest commentonticketfactorytest = commentOnTicketFactoryTest.instance();
	IcheckTicketExists checkticketexists =commentonticketfactorytest.checkticketexistsMock();
	@Test
	public void ticketExistsTest()
	{
		assertTrue(checkticketexists.ticketExists("12456"));
		assertFalse(checkticketexists.ticketExists("123"));
	}
}
