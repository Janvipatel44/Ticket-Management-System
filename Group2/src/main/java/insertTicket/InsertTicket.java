package insertTicket;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import database.ITicketOperationsDB;
import database.TicketOperationsDB;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
import insertTicket.Interfaces.IInsertTicket;

public class InsertTicket implements IInsertTicket{

	ITicketOperationsDB ticketOperationDB = null;
    IInputStringValidation ticketStringValidation = new InputStringValidation();
    IInputDateValidation dateValidation = new InputDateValidation();
    IInputRangeValidation rangeValidation = new InputRangeValidation();
    ICreateTicket createTicket = new CreateTicket();
    EnumValidation inputvalidaiton;

	public HashMap<String, String> userInputTicketDetails() throws ParseException 
	{
			Scanner sc = new Scanner(System.in);
		    HashMap<String, String> inputsHandler = new HashMap<String, String>();

			String ticketID = null;
		    String description = null;
		    String startDate = null;
		    String expectedEndDate = null;
		    String reporterID = null;
		    String employeeID = null;
		    String assigneeName = null;
		    String ticketType = null;    
		    String ticketStatus = null;		    
		    int priority = 0;
		    int urgency = 0;
		    int impact = 0;
		    String ticketLevel = null;		    
		    String customerID = null;
		    String customerName = null;
		    String creatorID = null;
		    String creatorName = null;
		    int rating = 0;
		    String attachmentID = null;  
		    long workingHours = 0;
		    long ticketOnHoldHours = 0;
		    long ticketInProgressHours= 0;
		    int count = 1;
		   		 
			System.out.println("Please enter ticket Id:");
			ticketID = sc.nextLine();
			ticketID = sc.nextLine();
		    createTicket.setTicketID(ticketID);
		    if(validation(description,EnumValidation.validateTicketID)) {
		    	inputsHandler.put("ticketID", ticketID);
		    }

			System.out.println("Please enter description:");
		    description = sc.nextLine();
		    createTicket.setDescription(description);
		    if(validation(description,EnumValidation.validateDescription)) {
		    	inputsHandler.put("description", ticketID);
		    }

			System.out.println("Start Date of Project is(YYYY-MM-DD):");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		    LocalDateTime now = LocalDateTime.now();  
		    System.out.println(dtf.format(now)); 
		    startDate = dtf.format(now);
		    createTicket.setStartDate(startDate);
	    	inputsHandler.put("startDate", startDate);


			System.out.println("Please enter expected end Date (YYYY-MM-DD):");
			expectedEndDate = sc.nextLine();
		    createTicket.setEndDate(expectedEndDate);
		    if(validation(description,EnumValidation.validateEndDate)) {
		    	inputsHandler.put("expectedEndDate", expectedEndDate);
		    }
		    
			System.out.println("Please enter reporter Id (EMPxxxx):");
		    reporterID = sc.nextLine();
		    createTicket.setReporterID(reporterID);
//
//			System.out.println("Please enter employee Id (EMPxxxx):");
//		    employeeId = sc.nextLine();
//		    createTicket.setEmployeeID(employeeId);

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
		    
		    
		    
			sc.close();
			return inputsHandler;
	}
	
	public boolean validation(String validationString, EnumValidation input) 
	{
		//null & special character, length
/*	    validateStartDate,		//automatically generated
	    validateExpectedEndDate,	//	range
	    validateEndDate,			//range	    
	    validateReporterID,			//employeeReporterPrefix , range, special character
	    validateEmployeeID,			//employeeReporterPrefix , range, special character
	    validateAssigneeName,		//range, special character
	    validateTicketType,			//not null, special character, range, 
	    validateTicketStatus,		// special character
	    validatePriority,			//range
	    validateImpact,				//range
	    validateUrgency,			//range
	    validateCustomerID,			//special character
	    validateCustomerName,		//special character
	    validateTicketLevel,		//not null
	    validateCreatorID,			//not null, special character, range
	    validateCreatorName,		//not null, special character, range
	    validateRating,				//range
	    validateAttachmentID,		
	    validateWorkingHours,		//non negative
	    validateTicketOnHoldHours,	//non negative 
	    validateTicketProgressHours	//non negative
*/	    
	    HashMap<String, Integer> stringLength = new HashMap<String, Integer>();
	    stringLength.put("ticketID", 30 );
	    stringLength.put("expectedEndDate", 10 );
	    stringLength.put("endDate", 10 );
	    stringLength.put("reporterID", 30 );
	    stringLength.put("employeeID", 30 );
	    stringLength.put("assigneeName", 45 );
	    stringLength.put("ticketType", 25 );
		boolean success = false;
            switch (input) 
            {
                case validateTicketID:
                	
            	    if(ticketStringValidation.isStringNull(validationString)==true) {
                   		success = false;
                        break;
            	    }
               	    if(ticketStringValidation.isStringContainsSpecialCharacters(validationString)==true) {
                   		System.err.println("String contains Special Characters");
                   		success = false;
                        break;
            	    }
            	    if(ticketStringValidation.isStringLengthValid(validationString,stringLength.get("ticketID"))==false) {
                   		System.err.println("Invalid String Length");
                   		success = false;
                        break;
            	    }
               		success = true;
                break;
                
                case validateDescription:
                	
                	 if(ticketStringValidation.isStringNull(validationString)==true) {
                    		success = false;
                         break;
             	    }
                	    if(ticketStringValidation.isStringContainsSpecialCharacters(validationString)==true) {
                    		System.err.println("String contains Special Characters");
                    		success = false;
                         break;
             	    }
                	success = true;
                break;
                case validateStartDate:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateExpectedEndDate:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateEndDate:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateReporterID:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateEmployeeID:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateAssigneeName:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateTicketType:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateTicketStatus:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validatePriority:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateImpact:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateUrgency:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateCustomerID:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateCustomerName:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateTicketLevel:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateCreatorID:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateCreatorName:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateRating:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateAttachmentID:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateWorkingHours:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateTicketOnHoldHours:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
                case validateTicketProgressHours:
               		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                    break;
            }
			return false;
           
	}
	public boolean validateInsertion() throws ParseException {
		
		List<String> stringNullValidationList = new ArrayList<String>();
		List<String> employeeReporterPrefixValidationList = new ArrayList<String>();
		List<String> specialCharacterValidationList = new ArrayList<String>();
		List<String> rangeValidationList = new ArrayList<String>();
		List<Integer> rangeLengthValidationList = new ArrayList<Integer>();
		List<String> dateValidationList = new ArrayList<String>();
		List<Integer> rangeIntValidationList = new ArrayList<Integer>();

		String ticketId = createTicket.getTicketID();;
	    String description = createTicket.getDescription();
	    String startDate = createTicket.getStartDate();
	    String endDate = createTicket.getEndDate();
	    String reporterId = createTicket.getReporterID();
	    String employeeId = createTicket.getEmployeeID();
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
	public void successfulInsertion() throws ParseException
	{
		boolean result = false;
	    HashMap<String, String> inputsHandler = new HashMap<String, String>();

		try {
			
			inputsHandler = userInputTicketDetails();
			ticketOperationDB = new TicketOperationsDB(inputsHandler);
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
