package insertTicket;

import java.text.ParseException;
import java.util.Scanner;

import insertTicket.Interfaces.IUserInputTicket;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.Interfaces.IUserInputValidation;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;

public class UserInputTicket implements IUserInputTicket {

	IInsertTicketFactory  insertTicketFactory = InsertTicketFactory.instance();
	ICreateTicket createTicket;
	IUserInputValidation userinput = insertTicketFactory.validation();
	IInsertTicket insertTicket;
	
	public boolean userInputTicketDetails() throws ParseException 
	{
		Scanner sc = new Scanner(System.in);
		String ticketID = null;
	    String description = null;
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

	    if(userinput.validation(ticketID,EnumValidation.validateTicketID) == false) {
	    	return false;
	    }


		System.out.println("Please enter description:");
	    description = sc.nextLine();

	    if(userinput.validation(description,EnumValidation.validateDescription) == false) {
	    	return false;
	    }

	
		System.out.println("Please enter expected end Date (YYYY-MM-DD):");
		expectedEndDate = sc.nextLine();

	    if(userinput.validation(expectedEndDate,EnumValidation.validateExpectedEndDate) == false) {
	    	return false;
	    }

		System.out.println("Please enter reporter Id (EMPxxxx):");
	    reporterID = sc.nextLine();

	    if(userinput.validation(reporterID,EnumValidation.validateReporterID) == false) {
	    	return false;
	    }

		System.out.println("Please enter employee Id (EMPxxxx):");
	    employeeID = sc.nextLine();

	    if(userinput.validation(employeeID,EnumValidation.validateEmployeeID) == false) {
	    	return false;
	    }

		System.out.println("Please enter assignee Name:");
	    assigneeName = sc.nextLine();

	    if(userinput.validation(assigneeName,EnumValidation.validateAssigneeName) == false) {
	    	return false;
	    }

		System.out.println("Please enter ticket Type (Bug/Feature/Research/Testing):");
	    ticketType = sc.nextLine();

	    if(userinput.validation(ticketType,EnumValidation.validateTicketType) == false) {
	    	return false;
	    }		

	  		
	    System.out.println("Please enter ticket Status:");
	    ticketStatus = sc.nextLine();

	    if(userinput.validation(ticketStatus,EnumValidation.validateTicketStatus) == false) {
	    	return false;
	    }	
		
		System.out.println("Please enter priority (1-5):");
	    priority = sc.nextInt();

	    if(userinput.validation(Integer.toString(priority),EnumValidation.validatePriority) == false) {
	    	return false;
	    }
		
		System.out.println("Please enter urgency (1-5):");
	    urgency = sc.nextInt();

	    if(userinput.validation(Integer.toString(urgency),EnumValidation.validateUrgency) == false) {
	    	return false;
	    }
		
	    
		System.out.println("Please enter impact (1-5):");
	    impact =  sc.nextInt();

	    if(userinput.validation(Integer.toString(impact),EnumValidation.validateImpact) == false) {
	    	return false;
	    }

	    		    
		System.out.println("Please Ticket Level:");
		ticketLevel = sc.nextLine();

		if(userinput.validation(ticketLevel,EnumValidation.validateTicketLevel) == false) {
	    	return false;
		}

		
		System.out.println("Please Customer ID:");
		customerID = sc.nextLine();
		if(userinput.validation(customerID,EnumValidation.validateCustomerID) == false) {
	    	return false;
		}
		
	    System.out.println("Please Customer Name:");
	    customerName = sc.nextLine();

	    if(userinput.validation(customerName,EnumValidation.validateCustomerName) == false) {
	    	return false;
		}

	    
	    System.out.println("Please Creator ID:");
	    creatorID = sc.nextLine();

	    if(userinput.validation(creatorID,EnumValidation.validateCreatorID) == false) {
	    	return false;
		}

	    
	    System.out.println("Please creator Name:");
	    creatorName = sc.nextLine();

	    if(userinput.validation(creatorName,EnumValidation.validateCreatorName) == false) {
	    	return false;
		}

	    sc.close();
	    createTicket = insertTicketFactory.getcreateTicket(ticketID, description, expectedEndDate, reporterID,
	    		employeeID, assigneeName, ticketType, ticketStatus, priority, urgency, impact, ticketLevel, customerID, 
	    		customerName, creatorID, creatorName);

	    insertTicket = insertTicketFactory.insertTicket(createTicket);
	    insertTicket.successfulInsertion();
	    
		return true;
	}

	
	//public boolean validateInsertion() throws ParseException {
		/*
		 * List<String> stringNullValidationList = new ArrayList<String>(); List<String>
		 * employeeReporterPrefixValidationList = new ArrayList<String>(); List<String>
		 * specialCharacterValidationList = new ArrayList<String>(); List<String>
		 * rangeValidationList = new ArrayList<String>(); List<Integer>
		 * rangeLengthValidationList = new ArrayList<Integer>(); List<String>
		 * dateValidationList = new ArrayList<String>(); List<Integer>
		 * rangeIntValidationList = new ArrayList<Integer>();
		 * 
		 * String ticketId = createTicket.getTicketID();; String description =
		 * createTicket.getDescription(); // String startDate =
		 * createTicket.getStartDate(); String endDate = createTicket.getEndDate();
		 * String reporterId = createTicket.getReporterID(); String employeeId =
		 * createTicket.getEmployeeID(); String assigneeName =
		 * createTicket.getAssigneeName(); String ticketType =
		 * createTicket.getTicketType(); int priority = createTicket.getPriority(); int
		 * urgency = createTicket.getUrgency(); int impact = createTicket.getImpact();
		 * String ticketLevel = createTicket.getTicketLevel();
		 * 
		 * int i = 0; stringNullValidationList.add(ticketId);
		 * stringNullValidationList.add(description);
		 * //stringNullValidationList.add(startDate);
		 * stringNullValidationList.add(ticketType); for (String validationString:
		 * stringNullValidationList) {
		 * 
		 * if(ticketStringValidation.isStringNull(validationString)==true) {
		 * System.out.print("Here Null"); return false; } }
		 * System.out.print("Null pachi");
		 * 
		 * specialCharacterValidationList.add(ticketId);
		 * specialCharacterValidationList.add(description);
		 * specialCharacterValidationList.add(reporterId);
		 * specialCharacterValidationList.add(employeeId);
		 * specialCharacterValidationList.add(assigneeName);
		 * specialCharacterValidationList.add(ticketType);
		 * 
		 * for (String validationString: specialCharacterValidationList) {
		 * if(ticketStringValidation.isStringContainsSpecialCharacters(validationString)
		 * ==true) { System.out.print("Here Special"); return false; } }
		 * 
		 * employeeReporterPrefixValidationList.add(employeeId);
		 * employeeReporterPrefixValidationList.add(reporterId);
		 * 
		 * for (String validationString: employeeReporterPrefixValidationList) {
		 * if(ticketStringValidation.isStringEmployeeAndReporterID(validationString)==
		 * false) {
		 * 
		 * System.out.print("Here Employee prefix validation for:" +validationString);
		 * return false; } } System.out.print("Employee pachi");
		 * 
		 * rangeValidationList.add(ticketId); rangeLengthValidationList.add(30);
		 * //rangeValidationList.add(startDate); //rangeLengthValidationList.add(10);
		 * rangeValidationList.add(endDate); rangeLengthValidationList.add(10);
		 * rangeValidationList.add(reporterId); rangeLengthValidationList.add(30);
		 * rangeValidationList.add(employeeId); rangeLengthValidationList.add(30);
		 * rangeValidationList.add(assigneeName); rangeLengthValidationList.add(45);
		 * rangeValidationList.add(ticketType); rangeLengthValidationList.add(25);
		 * 
		 * for (String validationString: rangeValidationList) {
		 * 
		 * if(ticketStringValidation.isStringLengthValid(validationString,
		 * rangeLengthValidationList.get(i))==false) { System.out.print("Here Range"
		 * +validationString.length()); return false; } i++; }
		 * System.out.print("Range pachi");
		 * 
		 * //dateValidationList.add(startDate); if(!endDate.equals(null) ||
		 * !endDate.equals("")) { System.out.print("Andar");
		 * 
		 * dateValidationList.add(endDate); }
		 * System.out.print(dateValidationList.size()); for (String validationString:
		 * dateValidationList) { System.out.print("Inner Format Invalid");
		 * 
		 * if(dateValidation.isDateFormatValid(validationString)==false &&
		 * !validationString.equals(null)) { System.out.print("Format Invalid"
		 * +dateValidation.isDateFormatValid(validationString)); return false; } else {
		 * System.out.print("Here Format Invalid"); } }
		 * System.out.print("Format pachi");
		 * 
		 * 
		 * if(!endDate.equals(null) || !endDate.equals(" ") || !endDate.equals("")) {
		 * if(dateValidation.isDurationValid(startDate, endDate)==false) {
		 * System.out.print("TicketDuration "); return false; } }
		 * 
		 * System.out.print("Duration pachi");
		 * 
		 * rangeIntValidationList.add(priority); rangeIntValidationList.add(urgency);
		 * rangeIntValidationList.add(impact);
		 * 
		 * for (Integer validationInt: rangeIntValidationList) {
		 * 
		 * if(rangeValidation.isRangeValid(validationInt)==false) {
		 * System.out.print("Range validation ");
		 * 
		 * return false; } } System.out.print("At Last"); return true;
		 */
		//return false;
	//}

	
}
