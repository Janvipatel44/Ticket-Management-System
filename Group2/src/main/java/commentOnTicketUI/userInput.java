package userInput;

import java.util.Scanner;

import commentOnTicket.abstractfactory.IcommentOnTicketFactory;
import commentOnTicket.abstractfactory.commentOnTicketFactory;
import commentOnTicket.interfaces.IConnectionManager;
import commentOnTicket.interfaces.IcommentOnTicket;
import commentOnTicket.interfaces.IdisplayTicket;
import commentOnTicket.interfaces.IstoreTicketData;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IgetListOfTickets;

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

		IcommentOnTicketFactory commentonticketfactory = commentOnTicketFactory.instance();
		IcheckTicketExists checkticketexists= commentonticketfactory.checkticketexists();
		IConnectionManager ConnectionMng = commentonticketfactory.ConnectionMng(ConfigurationFile);
		IstoreTicketData storeTicketData =commentonticketfactory.storeTicketData();
		IdisplayTicket displaytickets = commentonticketfactory.displaytickets();
		IgetListOfTickets getalltickets = commentonticketfactory.getalltickets(storeTicketData,displaytickets,ConnectionMng);
		IcommentOnTicket postComment = commentonticketfactory.postComment(ConnectionMng);
		
		getalltickets.listOfTickets();
		System.out.println("Enter Ticket Id you want to post comment on.:");
		ticketId = sc.next();
		result=checkticketexists.ticketExists(ticketId);
		sc.nextLine();
		if(result == true)
		{
			System.out.println("Write comment you want to post");
			commentString = sc.nextLine();
			commentPostResult=postComment.postCommentOnticket(ticketId,employeeID, commentString);
			System.out.println(commentPostResult);
		}
		else
		{
			System.out.println("Ticket with " + ticketId + "does not exists. Please provide valid ticketId.");
		}
		
		 
	}
}
