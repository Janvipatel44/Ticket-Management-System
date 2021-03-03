package sortTickets;

import java.util.Scanner;

public class sortTicketUI {
	public static void main(String args[]) {
		int choice=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Sort Ticket BY:");
		System.out.println("	1. Priority");
		System.out.println("	2. Urgency");
		System.out.println("	3. impact");
		System.out.println("Enter your choice:");
		choice=sc.nextInt();
		IsortTicket sortTicketobj=new sortTicket();
		if(choice<=3 || choice<=1) {
			sortTicketobj.sortTickets(choice);
		}
	}
}
