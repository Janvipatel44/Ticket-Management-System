package UserInput;

import java.util.Scanner;

import checkTicketExists.IcheckTicketExists;
import checkTicketExists.checkTicketExists;
import deleteTicket.IdeleteTicket;
import deleteTicket.deleteTicket;
import displayTicket.IdisplayTickets;
import displayTicket.displayTickets;
import getTickets.IgetListOfTickets;
import getTickets.getListOfTickets;

public class userInput 
{
	public static void main(String args[])
	{
		String ticketId = null;
		String userRole = "manager";
		String userenterRole = null;
		boolean result=false;
		Scanner sc = new Scanner(System.in);
		
		IcheckTicketExists checkticketexists=new checkTicketExists();
		IgetListOfTickets getalltickets = new getListOfTickets();
		IdisplayTickets displaytickets = new displayTickets();
		IdeleteTicket deleteticket = new deleteTicket();
		
		System.out.println("Enter your role:");
		userenterRole = sc.nextLine();
		if(userRole.equals(userenterRole))
		{
			getalltickets.listOfTickets();
			System.out.println("Enter Ticket Id you want to delete:");
			ticketId = sc.nextLine();
			result=checkticketexists.ticketExists(ticketId);
			if(result == true)
			{
				result = deleteticket.deleteticket(ticketId);
				System.out.println(result);
			}
			else 
			{
				System.out.println("Ticket does not exists");
			}
		}
		else
		{
			System.out.println("Sorry you can't delete ticket");
		}
	}
}
		
