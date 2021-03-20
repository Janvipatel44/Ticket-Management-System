package userInput;

import java.util.Scanner;

import checkTicketExists.IcheckTicketExists;
import checkTicketExists.checkTicketExists;
import commentOnTicket.IcommentOnTicket;
import commentOnTicket.commentOnTicket;
import getListOfTickets.IgetListOfTickets;
import getListOfTickets.getListOfTickets;

public class userInput 
{
	public static void main(String args[])
	{
		String ticketId = null;
		String commentString = null;
		boolean result = false;
		boolean commentPostResult=false;
		String UserName = "Machaj";
		Scanner sc = new Scanner(System.in);
		
		IcheckTicketExists checkticketexists=new checkTicketExists();
		IcommentOnTicket postComment = new commentOnTicket();
		IgetListOfTickets tickets = new getListOfTickets();
		
		tickets.listOfTickets();
		System.out.println("Enter Ticket Id you want to post comment on.:");
		ticketId = sc.next();
		result=checkticketexists.ticketExists(ticketId);
		sc.nextLine();
		if(result == true)
		{
			
			System.out.println("Write comment you want to post");
			commentString = sc.nextLine();
			commentPostResult=postComment.postCommentOnticket(ticketId,UserName, commentString);
			System.out.println(commentPostResult);
		}
		else
		{
			System.out.println("Ticket with " + ticketId + "does not exists. Please provide valid ticketId.");
		}
		
		 
	}
}
