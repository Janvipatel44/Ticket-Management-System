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
		   		 
			System.out.println("Please enter ticket Id:");
			ticketID = sc.nextLine();
		    if(validation(ticketID,EnumValidation.validateTicketID)) {
		    	inputsHandler.put("ticketID", ticketID);
		    }

			System.out.println("Please enter description:");
		    description = sc.nextLine();
		    if(validation(description,EnumValidation.validateDescription)) {
		    	inputsHandler.put("description", description);
		    }

			System.out.println("Start Date of Project is(YYYY-MM-DD):");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		    LocalDateTime now = LocalDateTime.now();  
		    System.out.println(dtf.format(now)); 
		    startDate = dtf.format(now);
	    	inputsHandler.put("startDate", startDate);

			System.out.println("Please enter expected end Date (YYYY-MM-DD):");
			expectedEndDate = sc.nextLine();
		    if(validation(expectedEndDate,EnumValidation.validateEndDate)) {
		    	inputsHandler.put("expectedEndDate", expectedEndDate);
		    }
		    
			System.out.println("Please enter reporter Id (EMPxxxx):");
		    reporterID = sc.nextLine();
		    if(validation(reporterID,EnumValidation.validateReporterID)) {
		    	inputsHandler.put("reporterID", reporterID);
		    }

			System.out.println("Please enter employee Id (EMPxxxx):");
		    employeeID = sc.nextLine();
		    if(validation(employeeID,EnumValidation.validateEmployeeID)) {
		    	inputsHandler.put("employeeID", employeeID);
		    }

			System.out.println("Please enter assignee Name:");
		    assigneeName = sc.nextLine();
		    if(validation(assigneeName,EnumValidation.validateAssigneeName)) {
		    	inputsHandler.put("assigneeName", assigneeName);
		    }
		    
			System.out.println("Please enter ticket Type (Bug/Feature/Research/Testing):");
		    ticketType = sc.nextLine();
		    if(validation(ticketType,EnumValidation.validateTicketType)) {
		    	inputsHandler.put("ticketType", ticketType);
		    }
		  		
		    System.out.println("Please enter ticket Status:");
		    ticketStatus = sc.nextLine();
		    if(validation(ticketStatus,EnumValidation.validateTicketStatus)) {
		    	inputsHandler.put("ticketStatus", ticketStatus);
		    }		    
		    
			System.out.println("Please enter priority (1-5):");
		    priority = sc.nextInt();
		    if(validation(Integer.toString(priority),EnumValidation.validatePriority)) {
		    	inputsHandler.put("priority", Integer.toString(priority));
		    }
		    
			System.out.println("Please enter urgency (1-5):");
		    urgency = sc.nextInt();
		    if(validation(Integer.toString(urgency),EnumValidation.validateUrgency)) {
		    	inputsHandler.put("urgency", Integer.toString(urgency));
		    }
		    
			System.out.println("Please enter impact (1-5):");
		    impact =  sc.nextInt();
		    if(validation(Integer.toString(impact),EnumValidation.validateImpact)) {
		    	inputsHandler.put("impact", Integer.toString(impact));
		    }
		    		    
			System.out.println("Please Ticket Level:");
			ticketLevel = sc.nextLine();
			if(validation(ticketLevel,EnumValidation.validateTicketLevel)) {
			    inputsHandler.put("ticketLevel",ticketLevel);
			}
			
			System.out.println("Please Customer ID:");
			customerID = sc.nextLine();
			if(validation(customerID,EnumValidation.validateCustomerID)) {
			    inputsHandler.put("customerID",customerID);
			}
			
		    System.out.println("Please Customer Name:");
		    customerName = sc.nextLine();
		    if(validation(customerName,EnumValidation.validateCustomerName)) {
			    inputsHandler.put("customerName",customerName);
			}		    
		    
		    System.out.println("Please Creator ID:");
		    creatorID = sc.nextLine();
		    if(validation(creatorID,EnumValidation.validateCreatorID)) {
			    inputsHandler.put("creatorID",creatorID);
			}	
		    
		    System.out.println("Please creator Name:");
		    creatorName = sc.nextLine();
		    if(validation(creatorName,EnumValidation.validateCreatorName)) {
			    inputsHandler.put("creatorName",creatorName);
			}
		    
			sc.close();
			return inputsHandler;
	}
	
	public boolean validation(String validationString, EnumValidation input) 
	{	
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
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateExpectedEndDate:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateEndDate:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateReporterID:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateEmployeeID:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateAssigneeName:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateTicketType:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateTicketStatus:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validatePriority:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateImpact:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateUrgency:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateCustomerID:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateCustomerName:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateTicketLevel:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateCreatorID:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateCreatorName:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateRating:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateAttachmentID:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateWorkingHours:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateTicketOnHoldHours:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
            case validateTicketProgressHours:
            	success = true;

           		System.err.println("Today is Monday learn example of How to use Java Enum in Switch");
                break;
        }
		return success;   
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
		System.out.print("Here I m in successfulInsertion");

		try {
			
			inputsHandler = userInputTicketDetails();
			ticketOperationDB = new TicketOperationsDB(inputsHandler);
			//result = ticketOperationDB.duplicateTicket();
				result = ticketOperationDB.insertTicket();
			//	System.out.print(result);
			//}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.print("Hello");
			e.printStackTrace();
		}
	}
}
