package searchingFunctionality;

import java.util.Scanner;

public class mainUIS {
	public static void main(String args[]) throws ClassNotFoundException {
		int choice=0;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("1. Ticket ID");
		System.out.println("2. Assignee");
		System.out.println("3. Ticket type");
		System.out.println("4. All Ticket");
		System.out.println("5. Ticket creator");
		System.out.println("6. keyword	");
		System.out.println("7. exit	");
		System.out.println("Please Provide your choice:");
		
		searchTicket obj=new searchTicket();
		do {
			System.out.println("Please Provide your choice:");
			choice=sc.nextInt();
			
			if(choice==1) {
				System.out.println("Please Provide TicketID:");
				int Id=sc.nextInt();
				obj.searchbyTicketId(Id);
			}else if(choice==2) {
				System.out.println("Please Provide name of Ticket Assignee:");
				String assigneeName=sc.next();
				obj.searchbyTicketAssignee(assigneeName);
			}else if(choice==3) {
				System.out.println("Please Provide Ticket Type:");
				String ticketType=sc.next();
				obj.searchbyTickettype(ticketType);
			}else if(choice==4) {
				System.out.println("All Tickets:");
				obj.searchbyAllTicket();
			}else if(choice==5) {
				System.out.println("Please Provide Name of Ticket Creator:");
				String ticketCreator=sc.next();
				obj.searchbyTicketCreator(ticketCreator);
				
			}else if(choice==6) {
				System.out.println("Please Provide Keyword:");
				String keyword=sc.next();
				obj.searchbyKeyword(keyword);
			}else {
				System.out.println("You have provided wrong input.Please choose the correct input value");
			}
		}
		while(choice!=7);
	}
}
