package commentOnTicketUI;

import java.util.Scanner;

import commentOnTicket.abstractfactory.IcommentOnTicketFactory;
import commentOnTicket.abstractfactory.commentOnTicketFactory;
import commentOnTicket.interfaces.IcommentOnTicket;
import database.ConnectionManager;
import database.IConnectionManager;
import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IstoreTicketData;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class userInput 
{
	
	public static void main(String args[])
	{
		String ticketId = null;
		String commentString = null;
		boolean result = false;
		boolean commentPostResult=false;
		String employeeID = "emp123";
		Scanner sc = new Scanner(System.in);
		final String ConfigurationFile = "ConfigurationFile";

		IConnectionManager ConnectionMng = new ConnectionManager(ConfigurationFile);
		IInputOutputHandler inputoutputhandler = new InputOutputHandler();
		IcommentOnTicketFactory commentonticketfactory = commentOnTicketFactory.instance();
		IcommentOnTicket postcomment = commentonticketfactory.postComment(ConnectionMng);
		IreuseableClassFactory reuseableclassfactory = reuseableClassFactory.instance();
		IcheckTicketExists checkticketexists= reuseableclassfactory.checkticketexists();
		
		IstoreTicketData storeTicketData =reuseableclassfactory.storeTicketData();
		IdisplayTicket displaytickets = reuseableclassfactory.displayUser(inputoutputhandler);
		IgetListOfTickets getalltickets = reuseableclassfactory.getalltickets(storeTicketData,displaytickets,ConnectionMng);
		
		
		getalltickets.listOfTickets();
		inputoutputhandler.displayMethod("Enter Ticket Id you want to post comment on.:");
		ticketId = inputoutputhandler.input();
		result=checkticketexists.ticketExists(ticketId);
		if(result == true)
		{
			inputoutputhandler.displayMethod("Write comment you want to post");
			commentString = inputoutputhandler.input();
			commentPostResult=postcomment.postCommentOnticket(ticketId,employeeID, commentString);
			if(commentPostResult==true)
			{
				inputoutputhandler.displayMethod("true");
			}
			else
			{
				inputoutputhandler.displayMethod("false");
			}
		}
		else
		{
			inputoutputhandler.displayMethod("Ticket with " + ticketId + "does not exists. Please provide valid ticketId.");
		}
		
		 
	}
}
