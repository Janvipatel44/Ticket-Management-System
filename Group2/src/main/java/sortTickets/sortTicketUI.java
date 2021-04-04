package sortTickets;

import java.util.Scanner;

import sortTickets.abstractfactory.ISortTicketFactory;
import sortTickets.abstractfactory.SortTicketFactory;
import sortTickets.interfaces.IConnectionManager;
import sortTickets.interfaces.IdisplayTicket;
import sortTickets.interfaces.IopenTicket;
import sortTickets.interfaces.IsortTicketData;
import sortTickets.interfaces.IstoreTicketData;

public class sortTicketUI {
	
	static Scanner sc=new Scanner(System.in);
	
	static String ConfigurationFile = "ConfigurationFile";
	
	static ISortTicketFactory storeticketfactory = SortTicketFactory.instance();
	static IstoreTicketData storeTicketData = storeticketfactory.storeTicketData();
	static IdisplayTicket displayUser = storeticketfactory.displayUser();
	static IConnectionManager ConnectionMng = storeticketfactory.ConnectionMng(ConfigurationFile);
	public static void main(String args[]) {
		int choice=0;
		
		System.out.println("Sort Ticket BY:");
		System.out.println("	1. Priority");
		System.out.println("	2. Urgency");
		System.out.println("	3. impact");
		System.out.println("Enter your choice:");
		choice=sc.nextInt();
		IsortTicketData sortTicketobj=new sortTicket(storeTicketData,displayUser,ConnectionMng);
		if(choice<=3 || choice<=1) {
			sortTicketobj.sortTickets(choice);
		}
		open();
	}
	
	private static void open() {
		int choice=0;
		String ticketID=null;
		IopenTicket openticket = storeticketfactory.openticket(storeTicketData,ConnectionMng);
		
		System.out.println("1. open Ticket");
		System.out.println("2. exit");
		
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
			
		}
		while(choice==1);
	}
	
}
