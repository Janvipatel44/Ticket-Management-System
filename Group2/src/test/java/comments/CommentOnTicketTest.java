package comments;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commentOnTicket.interfaces.ICommentOnTicket;
import comments.abstractfactory.ICommentOnTicketFactoryTest;
import comments.abstractfactory.CommentOnTicketFactoryTest;
import reuseableClasses.abstractfactory.IReuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.ReuseableClassFactoryTest;
import reuseablePackage.interfaces.ICheckTicketExists;
import reuseablePackage.interfaces.IGetListOfTickets;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class CommentOnTicketTest 
{
	@Test
	public void postCommentOnticket() 
	{
		IReuseableClassesFactoryTest reuseableclassfactorytest = ReuseableClassFactoryTest.instance();
		ICheckTicketExists checkticketexists =reuseableclassfactorytest.checkticketexistMock();
		IGetListOfTickets getalltickets =reuseableclassfactorytest.getlistofticketsMock();
		
		ICommentOnTicketFactoryTest commentonticketfactorytest = CommentOnTicketFactoryTest.instance();
		ICommentOnTicket postComment = commentonticketfactorytest. commentonticketMock();
		
		IInputOutputHandler inputoutputhandler = new InputOutputHandler();
		
		assertTrue(checkticketexists.ticketExists("111"));
		String output = getalltickets.listOfTickets();
		inputoutputhandler.displayMethod(output);
		assertTrue(postComment.postCommentOnticket("111", "Tejaswi","frequently occures bug"));
		
		
	}
}
