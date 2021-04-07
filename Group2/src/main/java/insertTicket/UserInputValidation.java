package insertTicket;

import java.text.ParseException;
import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
import insertTicket.Interfaces.IUserInputValidation;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;
import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class UserInputValidation implements IUserInputValidation {
	
	public boolean validation(String validationString, EnumValidation input) throws ParseException 
	{
		
		IInsertTicketFactory  insertTicketFactory = InsertTicketFactory.instance();

		IInputStringValidation ticketStringValidation = insertTicketFactory.ticketStringValidation();
		IInputDateValidation dateValidation = insertTicketFactory.dateValidation();
		IInputRangeValidation rangeValidation = insertTicketFactory.rangeValidation();
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IInputOutputHandler inputOutputHandler = userInterfaceFactory.getInputOutputHandler();
	
		
		boolean success = false;
		switch (input) 
		{
		
		case VALIDATETICKETID:
		case VALIDATEDESCRIPTION:
		case VALIDATECREATORNAME:
		case VALIDATECREATORID:
		case VALIDATECUSTOMERID:
		case VALIDATEASSIGNEENAME:
		case VALIDATECUSTOMERNAME:
		case VALIDATETICKETLEVEL:
		case VALIDATETICKETSTATUS:
		case VALIDATETICKETTYPE:

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
			success = true;
			break;	
			
		case VALIDATEEXPECTEDENDDATE:
		
			if (dateValidation.isDateFormatValid(validationString) == false ) {
				inputOutputHandler.displayMethod("Date format invalid");
				success = false;
				break;
			}
			if (dateValidation.isDurationValid(new java.sql.Timestamp(new java.util.Date().getTime()).toString(), validationString) == false ) {
				inputOutputHandler.displayMethod("Duration invalid");
				success = false;
				break;
			}
			success = true;

			break;
			
		case VALIDATEREPORTERID :
		case VALIDATEEMPLOYEEID:
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
			
		case VALIDATEPRIORITY:
		case VALIDATEIMPACT:
		case VALIDATEURGENCY:

			if(rangeValidation.isRangeValid(Integer.parseInt(validationString)) == false) 
			{
				System.err.println("Range not valid");
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
