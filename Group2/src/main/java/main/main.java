package main;

import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import insertTicket.UserInputTicket;
import insertTicket.Interfaces.IUserInputTicket;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;
import userinterface.GenerateTicketScreen;
import userinterface.IGenerateTicketScreen;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class main {
	
		public static void main (String[] args)  throws  NoSuchElementException, ParseException {
	 		
			int input = 0;
		    Scanner sc1 = new Scanner(System.in);
		    IUserInputTicket insert_tickets = new UserInputTicket();
		    String employeeId = null;
		    String date = null;
			IInsertTicketFactory  insertTicketFactory = InsertTicketFactory.instance();
			IInputOutputHandler inputOutputHandler = new InputOutputHandler();
			IGenerateTicketScreen generateTicketScreen = new GenerateTicketScreen(inputOutputHandler);
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
		            	//insertTicketFactory.inputTicket().userInputTicketDetails();
		            	generateTicketScreen.displayTicketGenerationScreen();
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