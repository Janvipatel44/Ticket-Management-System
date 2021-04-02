package InsertTickets;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import validations.InputDateValidationMock;
import validations.InputRangeValidationMock;
import validations.InputStringValidationMock;
import database.ITicketOperationsDB;
import database.TicketOperationsDB;
import insertTicket.CreateTicket;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
 
public class InsertTicketsMock {
	ITicketOperationsDB ticketOperationDB = null;
    IInputStringValidation ticketStringValidation = new InputStringValidationMock();
    IInputDateValidation dateValidation = new InputDateValidationMock();
    IInputRangeValidation rangeValidation = new InputRangeValidationMock();
    ICreateTicket createTicket = new CreateTicket();
	
	public boolean validateInsertion(ICreateTicket createTicket) throws ParseException {
		
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
	public void successfulInsertion(ICreateTicket createTicket)
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
