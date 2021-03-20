package comments;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import checkTicketExists.IcheckTicketExists;

public class CheckTicketExistsTest 
{
	IcheckTicketExists checkticketexists = new CheckTicketExistsMock();
	@Test
	public void ticketExistsTest()
	{
		assertTrue(checkticketexists.ticketExists("12456"));
		assertFalse(checkticketexists.ticketExists("123"));
	}
}
