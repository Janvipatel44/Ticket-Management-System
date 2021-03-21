package Tickets;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import database.ITicketOperationsDB;
import database.TicketOperationsDB;
import validations.IInputDateValidation;
import validations.IInputRangeValidation;
import validations.IInputStringValidation;
import validations.InputDateValidation;
import validations.InputRangeValidation;
import validations.InputStringValidation;

public class InsertTicket implements IInsertTicket{

	ITicketOperationsDB ticketOperationDB = null;
    IInputStringValidation ticketStringValidation = new InputStringValidation();
    IInputDateValidation dateValidation = new InputDateValidation();
    IInputRangeValidation rangeValidation = new InputRangeValidation();
    ICreateTicket createTicket = new CreateTicket();
    
    
 
	public void userInputTicketDetails() throws ParseException {
			Scanner sc = new Scanner(System.in);

			String ticketId = null;
		    String description = null;
		    String startDate = null;
		    String endDate = null;
		    String reporterId = null;
		    String employeeId = null;
		    String assigneeName = null;
		    String ticketType = null;
		    int priority = 0;
		    int urgency = 0;
		    int impact = 0;
		    String ticketLevel = null;
		    String customerName = null;
		    int rating = 0;
		    String creatorName = null;
		    String attachmentID = null;

		
			System.out.println("Please enter ticket Id:");
		    ticketId = sc.nextLine();
		    createTicket.setTicketId(ticketId);
		    
			System.out.println("Please enter description:");
		    description = sc.nextLine();
		    createTicket.setDescription(description);

			System.out.println("Please enter start Date (YYYY-MM-DD):");
		    startDate = sc.nextLine();
		    createTicket.setStartDate(startDate);

			System.out.println("Please enter end Date (YYYY-MM-DD):");
		    endDate = sc.nextLine();
		    createTicket.setEndDate(endDate);

			System.out.println("Please enter reporter Id (EMPxxxx):");
		    reporterId = sc.nextLine();
		    createTicket.setReporterId(reporterId);

			System.out.println("Please enter employee Id (EMPxxxx):");
		    employeeId = sc.nextLine();
		    createTicket.setEmployeeId(employeeId);

			System.out.println("Please enter assignee Name:");
		    assigneeName = sc.nextLine();
		    createTicket.setAssigneeName(assigneeName);

			System.out.println("Please enter ticket Type (Bug/Feature/Research/Testing):");
		    ticketType = sc.nextLine();
		    createTicket.setTicketType(ticketType);

			System.out.println("Please enter priority (1-5):");
		    priority = sc.nextInt();
		    createTicket.setPriority(priority);
		    
			System.out.println("Please enter urgency (1-5):");
		    urgency = sc.nextInt();
		    createTicket.setUrgency(urgency);

			System.out.println("Please enter impact (1-5):");
		    impact =  sc.nextInt();
		    createTicket.setImpact(impact);

			System.out.println("Please Ticket Level:");
			ticketLevel = sc.nextLine();
			ticketLevel = sc.nextLine();

		    createTicket.setTicketLevel(ticketLevel);
		   		    
		    System.out.println("Please Customer Name:");
		    customerName = sc.nextLine();
		    createTicket.setCustomerName(customerName);
		    
		    System.out.println("Please Rating:");
		    rating = sc.nextInt();
		    createTicket.setRating(rating);
		    
		    System.out.println("Please creator Name:");
		    creatorName = sc.nextLine();
		    creatorName = sc.nextLine();
		    createTicket.setCreatorName(creatorName);
		    
		    System.out.println("Please attachment ID:");
		    attachmentID = sc.nextLine();
		    attachmentID = sc.nextLine();
		    createTicket.setAttchmentID(attachmentID);
		    
		    if(validateInsertion()==true) {
		    	successfulInsertion();
		    }
			sc.close();
	}
	
	public boolean validateInsertion() throws ParseException {
		
		List<String> stringNullValidationList = new ArrayList<String>();
		List<String> employeeReporterPrefixValidationList = new ArrayList<String>();
		List<String> specialCharacterValidationList = new ArrayList<String>();
		List<String> rangeValidationList = new ArrayList<String>();
		List<Integer> rangeLengthValidationList = new ArrayList<Integer>();
		List<String> dateValidationList = new ArrayList<String>();
		List<Integer> rangeIntValidationList = new ArrayList<Integer>();

		String ticketId = createTicket.getTicketId();;
	    String description = createTicket.getDescription();
	    String startDate = createTicket.getStartDate();
	    String endDate = createTicket.getEndDate();
	    String reporterId = createTicket.getReporterId();
	    String employeeId = createTicket.getEmployeeId();
	    String assigneeName = createTicket.getAssigneeName();
	    String ticketType = createTicket.getTicketType();
	    int priority = createTicket.getPriority();
	    int urgency = createTicket.getUrgency();
	    int impact = createTicket.getImpact();
	    String ticketLevel = createTicket.getTicketLevel();
	    
		int i = 0;
		stringNullValidationList.add(ticketId);
		stringNullValidationList.add(description);
		stringNullValidationList.add(startDate);
		stringNullValidationList.add(ticketType);
		for (String validationString: stringNullValidationList) {

				if(ticketStringValidation.isStringNull(validationString)==true) {
					System.out.print("Here Null");
					return false;
				}
		}
		System.out.print("Null pachi");

		specialCharacterValidationList.add(ticketId);
		specialCharacterValidationList.add(description);
		specialCharacterValidationList.add(reporterId);
		specialCharacterValidationList.add(employeeId);
		specialCharacterValidationList.add(assigneeName);
		specialCharacterValidationList.add(ticketType);

		for (String validationString: specialCharacterValidationList) {
			if(ticketStringValidation.isStringContainsSpecialCharacters(validationString)==true) {
				System.out.print("Here Special");
				return false;
			}
		}
	
		employeeReporterPrefixValidationList.add(employeeId);
		employeeReporterPrefixValidationList.add(reporterId);

		for (String validationString: employeeReporterPrefixValidationList) {
			if(ticketStringValidation.isStringEmployeeAndReporterID(validationString)==false) {
				
				System.out.print("Here Employee prefix validation for:" +validationString);
				return false;
			}
		}
		System.out.print("Employee pachi");

		rangeValidationList.add(ticketId);
		rangeLengthValidationList.add(30);
		rangeValidationList.add(startDate);
		rangeLengthValidationList.add(10);
		rangeValidationList.add(endDate);
		rangeLengthValidationList.add(10);
		rangeValidationList.add(reporterId);
		rangeLengthValidationList.add(30);
		rangeValidationList.add(employeeId);
		rangeLengthValidationList.add(30);
		rangeValidationList.add(assigneeName);
		rangeLengthValidationList.add(45);
		rangeValidationList.add(ticketType);
		rangeLengthValidationList.add(25);
		//System.out.print("Length " +rangeLengthValidationList.);

		for (String validationString: rangeValidationList) {

			if(ticketStringValidation.isStringLengthValid(validationString, rangeLengthValidationList.get(i))==false) {
				System.out.print("Here Range" +validationString.length());
				return false;
			}
			i++;
		}
		System.out.print("Range pachi");

		dateValidationList.add(startDate);
		if(!endDate.equals(null) || !endDate.equals("")) {
			System.out.print("Andar");

			dateValidationList.add(endDate);
		}
		System.out.print(dateValidationList.size());
		for (String validationString: dateValidationList)
		{	
			System.out.print("Inner Format Invalid");

			if(dateValidation.isDateFormatValid(validationString)==false && !validationString.equals(null))
			{
				System.out.print("Format Invalid" +dateValidation.isDateFormatValid(validationString));
				return false;
			}
			else {
				System.out.print("Here Format Invalid");
			}
		}
		System.out.print("Format pachi");

		if(!endDate.equals(null) || !endDate.equals(" ") || !endDate.equals("")) {
			if(dateValidation.isDurationValid(startDate, endDate)==false) {
				System.out.print("TicketDuration ");
				return false;
			}
		}
		System.out.print("Duration pachi");

		rangeIntValidationList.add(priority);
		rangeIntValidationList.add(urgency);
		rangeIntValidationList.add(impact);
		
		for (Integer validationInt: rangeIntValidationList) {
			
			if(rangeValidation.isRangeValid(validationInt)==false) {
				System.out.print("Range validation ");

				return false;
			}
		}
		System.out.print("At Last");
		return true;
	}
	public void successfulInsertion()
	{
		boolean result = false;

		try {
			
			ticketOperationDB = new TicketOperationsDB(createTicket);
			result = ticketOperationDB.duplicateTicket();
			if(result==false) {
				result = ticketOperationDB.insertTicket();
				System.out.print(result);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.print("Hello");
			e.printStackTrace();
		}
	}
}
