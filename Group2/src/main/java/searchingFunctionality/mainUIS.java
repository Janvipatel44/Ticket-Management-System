package searchingFunctionality;

import java.util.Scanner;

public class mainUIS 
{
	public static void main(String args[]) throws ClassNotFoundException 
	{
		int choice=0;
		String searchInput=null;
		Scanner sc=new Scanner(System.in);
		
		//searchTicket class object
		IsearchTicket obj=new searchTicket();
		
		//Available options for user 
		System.out.println("1. Ticket ID");
		System.out.println("2. Assignee");
		System.out.println("3. Ticket type");
		System.out.println("4. All Ticket");
		System.out.println("5. Ticket creator");
		System.out.println("6. keyword	");
		System.out.println("7. exit	");
			
		do 
		{
			System.out.println("Please Provide your choice:");
			choice=sc.nextInt();
			
			if(choice==1) 
			{
				System.out.println("Please Provide TicketID:");
				searchInput=sc.next();
				obj.searchbyTicket(choice, searchInput);
			}
			else if(choice==2)
			{
				System.out.println("Please Provide name of Ticket Assignee:");
				searchInput=sc.next();
				obj.searchbyTicket(choice, searchInput);
			}
			else if(choice==3) 
			{
				System.out.println("Please Provide Ticket Type:");
				searchInput=sc.next();
				obj.searchbyTicket(choice, searchInput);
			}
			else if(choice==4) 
			{
				System.out.println("All Tickets:");
				obj.searchbyTicket(choice, searchInput);
			}
			else if(choice==5) 
			{
				System.out.println("Please Provide Name of Ticket Creator:");
				searchInput=sc.next();
				obj.searchbyTicket(choice, searchInput);
			}
			else if(choice==6) 
			{
				System.out.println("Please Provide Keyword:");
				searchInput=sc.next();
				obj.searchbyTicket(choice, searchInput);
			}
			else 
			{
				System.out.println("You have provided wrong input.Please choose the correct input value");
			}
		}
		while(choice!=7);
	}
}
