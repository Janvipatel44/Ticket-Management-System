package comments;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import checkTicketExists.IcheckTicketExists;
import commentOnTicket.IcommentOnTicket;
import displayTickets.IdisplayTicket;
import displayTickets.displayTicket;
import getListOfTickets.IgetListOfTickets;

public class commentOnTicketTest 
{
	@Test
	public void postCommentOnticket() 
	{
		IcheckTicketExists checkticketexists=new CheckTicketExistsMock();
		IdisplayTicket displaytickets = new displayTicket();
		IgetListOfTickets getalltickets = new getListOfTicketsMock(displaytickets);
		IcommentOnTicket postComment = new commentOnTicketMock();
		assertTrue(checkticketexists.ticketExists("12456"));
		getalltickets.listOfTickets();
		assertTrue(postComment.postCommentOnticket("12456", "Tejaswi","frequently occures bug"));
		
		
	}
}
