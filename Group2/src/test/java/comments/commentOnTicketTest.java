package comments;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commentOnTicket.interfaces.IcommentOnTicket;
import comments.abstractfactory.IcommentOnTicketFactoryTest;
import comments.abstractfactory.commentOnTicketFactoryTest;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class commentOnTicketTest 
{
	@Test
	public void postCommentOnticket() 
	{
		IcommentOnTicketFactoryTest commentonticketfactorytest = commentOnTicketFactoryTest.instance();
		IInputOutputHandler inputoutputhandler = new InputOutputHandler();
		IcheckTicketExists checkticketexists=commentonticketfactorytest.checkticketexistsMock();
		IdisplayTicket displaytickets = commentonticketfactorytest.displaytickets(inputoutputhandler);
		IgetListOfTickets getalltickets =commentonticketfactorytest.getallticketsMock(displaytickets);
		IcommentOnTicket postComment = commentonticketfactorytest. commentonticketMock();
		assertTrue(checkticketexists.ticketExists("12456"));
		getalltickets.listOfTickets();
		assertTrue(postComment.postCommentOnticket("12456", "Tejaswi","frequently occures bug"));
		
		
	}
}
