package comments;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commentOnTicket.interfaces.IcheckTicketExists;
import commentOnTicket.interfaces.IcommentOnTicket;
import commentOnTicket.interfaces.IdisplayTicket;
import commentOnTicket.interfaces.IgetListOfTickets;
import comments.abstractfactory.IcommentOnTicketFactoryTest;
import comments.abstractfactory.commentOnTicketFactoryTest;

public class commentOnTicketTest 
{
	@Test
	public void postCommentOnticket() 
	{
		IcommentOnTicketFactoryTest commentonticketfactorytest = commentOnTicketFactoryTest.instance();
		IcheckTicketExists checkticketexists=commentonticketfactorytest.checkticketexists();
		IdisplayTicket displaytickets = commentonticketfactorytest.displaytickets();
		IgetListOfTickets getalltickets =commentonticketfactorytest.getalltickets(displaytickets);
		IcommentOnTicket postComment = commentonticketfactorytest. commentonticketMock();
		assertTrue(checkticketexists.ticketExists("12456"));
		getalltickets.listOfTickets();
		assertTrue(postComment.postCommentOnticket("12456", "Tejaswi","frequently occures bug"));
		
		
	}
}
