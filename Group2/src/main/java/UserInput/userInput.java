package UserInput;

import java.util.Scanner;

import checkTicketExists.IcheckTicketExists;
import checkTicketExists.checkTicketExists;
import deleteTicket.IdeleteTicket;
import deleteTicket.deleteTicket;
import getTickets.IgetListOfTickets;
import getTickets.getListOfTickets;
import updateTicketDetails.IupdateTicket;
import updateTicketDetails.updateTicket;

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
		IdeleteTicket deleteticket = new deleteTicket();
		IupdateTicket updateTicket = new updateTicket();
		
		System.out.println("Enter your role:");
		userenterRole = sc.nextLine();
		System.out.println("Tickets Details");
		getalltickets.listOfTickets();
		System.out.println("1. update");
		System.out.println("1. delete");
		System.out.println("Enter operation you want to perform");
		int choice = sc.nextInt();
		if(userRole.equals(userenterRole) && choice ==1)
		{
			System.out.println("Enter Ticket Id you want to update:");
			ticketId = sc.next();
			result=checkticketexists.ticketExists(ticketId);
			if(result == true)
			{
				System.out.println("1. Expected Date");
				System.out.println("2. Reporter ID");
				System.out.println("3. Assignee Name");
				System.out.println("4. priority");
				System.out.println("5. urgency");
				System.out.println("6. impact");
				System.out.println("Please provide your choice");
				int choiceToUpdate = sc.nextInt();
				System.out.println("Enter Update Value:");
				String value = sc.next();
				
				result = updateTicket.updateValueOfRow(ticketId,choiceToUpdate,value);
				System.out.println(result);
			}
			else 
			{
				System.out.println("Ticket does not exists");
			}
		}
		else if(userRole.equals(userenterRole) && choice ==2)
		{
			
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
		
