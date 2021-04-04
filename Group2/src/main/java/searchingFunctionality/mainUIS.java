package searchingFunctionality;

import java.util.Scanner;

import abstarctfactory.IsearchFactory;
import abstarctfactory.searchFactory;
import searchTicket.interfaces.IConnectionManager;
import searchTicket.interfaces.IdisplayTicket;
import searchTicket.interfaces.IexportTicket;
import searchTicket.interfaces.IopenTicket;
import searchTicket.interfaces.IsearchTicket;
import searchTicket.interfaces.IstoreTicketData;

public class mainUIS 
{
	static Scanner sc=new Scanner(System.in);
	static String ConfigurationFile = "ConfigurationFile";
//	static IstoreTicketData storeTicketData = new storeTicketData();
//	static IdisplayTicket displayUser = new displayTicket();
//	static IConnectionManager ConnectionMng = new ConnectionManager(ConfigurationFile);

	static IsearchFactory searchticketfactory = searchFactory.instance(); 
	static IstoreTicketData storeticketdata = searchticketfactory.storeTicketData();
	static IdisplayTicket displayuser = searchticketfactory.displayUser();
	static IConnectionManager connectionMng = searchticketfactory.ConnectionMng(ConfigurationFile);
	static IsearchTicket searchticket= searchticketfactory.searchticket(storeticketdata, connectionMng);
	static IopenTicket openticket = searchticketfactory.openticket(storeticketdata, connectionMng);
	static IexportTicket exportTicketData = searchticketfactory.exportTicketData(storeticketdata);
	
	public static void main(String args[]) throws ClassNotFoundException 
	{
		int choice=0;
		String searchInput=null;
		
		
		
		//searchTicket class object
		
		
		
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
				searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==2)
			{
				System.out.println("Please Provide name of Ticket Assignee:");
				searchInput=sc.next();
				searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==3) 
			{
				System.out.println("Please Provide Ticket Type:");
				searchInput=sc.next();
				searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==4) 
			{
				System.out.println("All Tickets:");
				searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==5) 
			{
				System.out.println("Please Provide Name of Ticket Creator:");
				searchInput=sc.next();
				searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==6) 
			{
				System.out.println("Please Provide Keyword:");
				searchInput=sc.next();
				searchticket.searchbyTicket(choice, searchInput);
			}
			else 
			{
				System.out.println("You have provided wrong input.Please choose the correct input value");
			}
			
			open();
		}
		while(choice!=7);
	}

	private static void open() {
		int choice=0;
		String ticketID=null;
				
		System.out.println("1. open Ticket");
		System.out.println("2. Export Ticket");
		System.out.println("3. exit");
		
		do 
		{
			System.out.println("Choose Operation you want to perform");
			choice=sc.nextInt();
			sc.nextLine();
			if(choice == 1)
			{
				
				System.out.println("Enter Ticket ID:");
				ticketID = sc.nextLine();
				openticket.openticket(ticketID) ;
			}
			else if(choice == 2)
			{
				String FileName = "";
				System.out.println("Enter FileName with Path:");
				FileName = sc.nextLine();
				exportTicketData.exportTicket(FileName);
				
			}
		}
		while(choice!=3);
	}
}
