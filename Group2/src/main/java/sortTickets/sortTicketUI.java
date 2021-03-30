package sortTickets;

import java.util.Scanner;

import StoreTicketData.IstoreTicketData;
import StoreTicketData.storeTicketData;
import database.ConnectionManager;
import database.IConnectionManager;
import displayTickets.IdisplayTicket;
import displayTickets.displayTicket;
import openTicketOption.IopenTicket;
import openTicketOption.openTicket;

public class sortTicketUI {
	
	static Scanner sc=new Scanner(System.in);
	
	static String ConfigurationFile = "ConfigurationFile";
	static IstoreTicketData storeTicketData = new storeTicketData();
	static IdisplayTicket displayUser = new displayTicket();
	static IConnectionManager ConnectionMng = new ConnectionManager(ConfigurationFile);
	
	public static void main(String args[]) {
		int choice=0;
		
		System.out.println("Sort Ticket BY:");
		System.out.println("	1. Priority");
		System.out.println("	2. Urgency");
		System.out.println("	3. impact");
		System.out.println("Enter your choice:");
		choice=sc.nextInt();
		IsortTicket sortTicketobj=new sortTicket(storeTicketData,displayUser,ConnectionMng);
		if(choice<=3 || choice<=1) {
			sortTicketobj.sortTickets(choice);
		}
		open();
	}
	
	private static void open() {
		int choice=0;
		String ticketID=null;
		IopenTicket openticket = new openTicket(storeTicketData,displayUser,ConnectionMng);
		
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
