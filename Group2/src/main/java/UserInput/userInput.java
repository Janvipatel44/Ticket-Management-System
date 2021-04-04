package UserInput;

import java.text.ParseException;
import java.util.Scanner;

import interfacs.IcheckTicketExists;
import interfacs.IgetListOfTickets;
import updateTicketDetails.checkTicketExists;
import updateTicketDetails.deleteTicket;
import updateTicketDetails.getListOfTickets;
import updateTicketDetails.updateTicket;
import updateTicketDetails.interfaces.IdeleteTicket;
import updateTicketDetails.interfaces.IupdateTicket;

public class userInput 
{
	public static void main(String args[])
	{
		String ticketId = null;
		String userRole = "manager";
		String empployeeID = "emp123";
		boolean result=false;
		Scanner sc = new Scanner(System.in);
		
		IcheckTicketExists checkticketexists=new checkTicketExists();
		IgetListOfTickets getalltickets = new getListOfTickets();
		IdeleteTicket deleteticket = new deleteTicket();
		IupdateTicket updateTicket = new updateTicket();
		
//		IupdateTicketFactory updateticketfactory = updateTicketFactory.instance(); 
//		IcheckTicketExists checkticketexists = updateticketfactory.getcheckticketexists();
//		IgetListOfTickets getalltickets = updateticketfactory.getalltickets();
//		IdeleteTicket deleteticket = updateticketfactory.deleteticket();
//		IupdateTicket updateTicket = updateticketfactory.updateTicket();
		
		System.out.println("Enter your role:");
		String userenterRole = sc.nextLine();
		System.out.println("Tickets Details");
		getalltickets.listOfTickets();
		System.out.println("1. update");
		System.out.println("2. delete");
		System.out.println("Enter operation you want to perform");
		int choice = sc.nextInt();
		if(choice ==1)
		{
			if(userRole.equals(userenterRole))
			{
				System.out.println("Enter Ticket Id you want to update:");
				ticketId = sc.next();
				result=checkticketexists.ticketExistsForCreator(ticketId,empployeeID);
				if(result == true)
				{
					System.out.println("1. Expected Date");
					System.out.println("2. Reporter ID");
					System.out.println("3. Assignee Name");
					System.out.println("4. priority");
					System.out.println("5. urgency");
					System.out.println("6. impact");
					System.out.println("7. status of ticket");
					System.out.println("Please provide your choice");
					int choiceToUpdate = sc.nextInt();
					System.out.println("Enter Update Value:");
					String value = sc.next();
					if(choiceToUpdate == 7)
					{
						try {
							result = updateTicket.updateValueOfTicketForNotManager(ticketId,value);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					else
					{
						result = updateTicket.updateValueOfTicketForManager(ticketId,choiceToUpdate,value);
					}
					System.out.println(result);
				}
				else
				{
					System.out.println("Please provide valid ticket id. You are either not allow to update tickets data, or ticket with given id does not exists");
				}
					
			}
			else
			{
				System.out.println("Enter Ticket Id you want to update:");
				ticketId = sc.next();
				result = checkticketexists.ticketExistsForAssignee(ticketId,empployeeID);
				if(result == true)
				{
					System.out.println("Change Ticket Status");
					System.out.println("Enter Ticket Status:");
					String value = sc.next();
					
					try {
						result = updateTicket.updateValueOfTicketForNotManager(ticketId,value);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(result);
				}
				else
				{
					System.out.println("Please provide valid ticket id. You are either not allow to update tickets data, or ticket with given id does not exists");
				}
		
			}
		}
		else if(userRole.equals(userenterRole) && choice == 2)
		{
			
			System.out.println("Enter Ticket Id you want to delete:");
			ticketId = sc.nextLine();
			result=checkticketexists.ticketExistsForCreator(ticketId, empployeeID);
			if(result == true)
			{
				result = deleteticket.deleteticket(ticketId);
				System.out.println(result);
			}
			else
			{
				System.out.println("Please provide valid ticket id. You are either not allow to update tickets data, or ticket with given id does not exists");
			}
		}
		else
		{
			System.out.println("Sorry you can't delete ticket");
		}
	}
}
		
