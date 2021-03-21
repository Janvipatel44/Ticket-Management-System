package main;

import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Tickets.IInsertTicket;
import Tickets.InsertTicket;

public class main {
	
		public static void main (String[] args)  throws  NoSuchElementException, ParseException {
	 		
			int input = 0;
		    Scanner sc1 = new Scanner(System.in);
		    IInsertTicket insert_tickets = new InsertTicket();
		    String employeeId = null;
		    String date = null;
		    while(input != -1){
		        System.out.println("Please enter your desired operation:");
		        System.out.println("1: Create Tickets");
		        System.out.println("2: Employee Efficiency Report");
		        System.out.println("3: SLA Feature");
		        System.out.println("4: LinkedIn/Twitter");

		        input = sc1.nextInt();
		       
		        switch (input) {
		            
		        	case 0:
		            	System.out.println("Exit.");
		            break;
		       
		            case 1:
		            	try {
							insert_tickets.userInputTicketDetails();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            break;
		            
		            case 2:
					Scanner sc = new Scanner(System.in);

        	
					System.out.println("Please enter ticket Id:");
					employeeId = sc.nextLine();
					
					System.out.println("Please provide date from when reports needs to be generated:");
					date = sc.nextLine();
        	
//					employee_details.setDate(date);
//					employee_details.setEmployeeId(employeeId);
					sc.close();
		            break;
		            
		        }
			    
		    }
		}
}