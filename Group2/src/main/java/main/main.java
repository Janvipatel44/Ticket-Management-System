package main;

import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import employeePerformance.Interfaces.IUserInputEmployeePerformance;
import employeePerformance.abstractFactory.EmployeePerformanceFactory;
import employeePerformance.abstractFactory.IEmployeePerformanceFactory;
import insertTicket.UserInputTicket;
import insertTicket.Interfaces.IUserInputTicket;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;
import login.ParameterizedUser;
import login.Interfaces.IParameterizedUser;
import menucontroller.EmployeePerformanceReportTask;
import userinterface.EmployeePerformanceScreen;
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
			IInputOutputHandler inputoutputhandler = new InputOutputHandler();
			//IParameterizedUser user = new ParameterizedUser();
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
					
		            break;
		            
		            case 2:
		            	//EmployeePerformanceReportTask employee = new EmployeePerformanceReportTask();
		            	//employee.runMenuTask("new", inputoutputhandler);
		            	EmployeePerformanceScreen employee = new EmployeePerformanceScreen(inputoutputhandler);
		            	employee.displayTicketGenerationScreen();
		            break;
		            
		        }
			    
		    }
		}
}