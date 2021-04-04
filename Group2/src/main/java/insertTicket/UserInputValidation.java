package insertTicket;

import java.util.HashMap;

import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
import insertTicket.Interfaces.IUserInputValidation;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;

public class UserInputValidation implements IUserInputValidation {
	
	public boolean validation(String validationString, EnumValidation input) 
	{
		
		IInsertTicketFactory  insertTicketFactory = InsertTicketFactory.instance();

		IInputStringValidation ticketStringValidation = insertTicketFactory.ticketStringValidation();
		IInputDateValidation dateValidation = insertTicketFactory.dateValidation();
		IInputRangeValidation rangeValidation = insertTicketFactory.rangeValidation();
		
		HashMap<String, Integer> stringLength = new HashMap<String, Integer>();
		stringLength.put("ticketID", 30);
		stringLength.put("expectedEndDate", 10);
		stringLength.put("endDate", 10);
		stringLength.put("reporterID", 30);
		stringLength.put("employeeID", 30);
		stringLength.put("assigneeName", 45);
		stringLength.put("ticketType", 25);
		boolean success = false;
		switch (input) {
		case validateTicketID:

			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("Null String");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringLengthValid(validationString, stringLength.get("ticketID")) == false) {
				System.err.println("Invalid String Length");
				success = false;
				break;
			}
			success = true;
			break;

		case validateDescription:

			if (ticketStringValidation.isStringNull(validationString) == true) {
				success = false;
				break;
			}
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			success = true;
			break;
		case validateExpectedEndDate:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			success = true;

			break;
		case validateReporterID:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if(ticketStringValidation.isStringEmployeeAndReporterID(validationString) == false) {
				System.err.println("EMP not found");
				success = false;
				break;
			}
			success = true;

			break;
		case validateEmployeeID:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if(ticketStringValidation.isStringEmployeeAndReporterID(validationString) == false) {
				System.err.println("EMP not found");
				success = false;
				break;
			}
			success = true;

			break;
			
		case validateAssigneeName:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			/*
			 * if(ticketStringValidation.isStringLengthValid(validationString,
			 * rangeLengthValidationList.get(i))==false)) {
			 * System.err.println("EMP not found"); success = false; break; }
			 */
			success = true;

			break;
		case validateTicketType:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			success = true;

			break;
		case validateTicketStatus:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			success = true;

			break;
		case validatePriority:
			
			success = true;

			break;
		case validateImpact:
			success = true;

			break;
		case validateUrgency:
			success = true;

			break;
		case validateCustomerID:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			success = true;

			break;
		case validateCustomerName:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			success = true;

			break;
		case validateTicketLevel:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			success = true;

			break;
		case validateCreatorID:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			success = true;

			break;
		case validateCreatorName:
			if (ticketStringValidation.isStringContainsSpecialCharacters(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			if (ticketStringValidation.isStringNull(validationString) == true) {
				System.err.println("String contains Special Characters");
				success = false;
				break;
			}
			success = true;

			break;
		
		
		default:
			break;
		}
		return success;
	}

}
