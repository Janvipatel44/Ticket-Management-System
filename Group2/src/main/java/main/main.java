package main;

import java.text.ParseException;
import java.util.NoSuchElementException;

import Tickets.IInsertTicket;
import Tickets.InsertTicket;

public class main {
	
		public static void main (String[] args)  throws  NoSuchElementException {
	 		
			//int input = -2;
		    //Scanner sc1 = new Scanner(System.in);
		    IInsertTicket insert_tickets = new InsertTicket();
		  /*  while(input != -1){
		        System.out.println("Please enter your desired operation:");
		        System.out.println("0: Login/Sign up");
		        System.out.println("1: Create Tickets");
		        System.out.println("2: Search Tickets");
		        input = sc1.nextInt();
		        switch (input) {
		            
		        	case 0:
		            	System.out.println("Exit.");
		            break;
		      
		            case 1:*/
		            	try {
							insert_tickets.userInputTicketDetails();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		      /*      break;
		            
		            default:
		        }*/
		    }
		   // sc1.close();     	
}