package comments;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commentOnTicket.interfaces.IcommentOnTicket;
import comments.abstractfactory.IcommentOnTicketFactoryTest;
import comments.abstractfactory.commentOnTicketFactoryTest;
import reuseableClasses.abstractfactory.IreuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.reuseableClassFactoryTest;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IgetListOfTickets;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class commentOnTicketTest 
{
	@Test
	public void postCommentOnticket() 
	{
		IreuseableClassesFactoryTest reuseableclassfactorytest = reuseableClassFactoryTest.instance();
		IcheckTicketExists checkticketexists =reuseableclassfactorytest.checkticketexistMock();
		IgetListOfTickets getalltickets =reuseableclassfactorytest.getlistofticketsMock();
		
		IcommentOnTicketFactoryTest commentonticketfactorytest = commentOnTicketFactoryTest.instance();
		IcommentOnTicket postComment = commentonticketfactorytest. commentonticketMock();
		
		IInputOutputHandler inputoutputhandler = new InputOutputHandler();
		
		assertTrue(checkticketexists.ticketExists("111"));
		String output = getalltickets.listOfTickets();
		inputoutputhandler.displayMethod(output);
		assertTrue(postComment.postCommentOnticket("111", "Tejaswi","frequently occures bug"));
		
		
	}
}
