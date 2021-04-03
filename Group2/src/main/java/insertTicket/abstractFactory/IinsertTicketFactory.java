package insertTicket.abstractFactory;

import java.text.ParseException;
import java.util.Date;

import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.Interfaces.IParameterizedTicket;
import insertTicket.Interfaces.IUserInputValidation;

public interface IinsertTicketFactory {

	public IInsertTicket userInputTicketDetails() throws ParseException;
	public IInsertTicket successfulInsertion() throws ParseException;
	
	public IUserInputValidation validateInsertion() throws ParseException;

	public IInputDateValidation isDurationValid (String startDate, String endDate) throws ParseException;
	public IInputDateValidation isDateFormatValid (String validationString) throws ParseException;

	public IInputRangeValidation isRangeValid (int inputValue);

	public IInputStringValidation isStringNull(String validationString);
	public IInputStringValidation isStringContainsSpecialCharacters(String validationString);
	public IInputStringValidation isStringEmployeeAndReporterID (String validationString);
	public IInputStringValidation isStringLengthValid (String validationString, int length);
	
	public IParameterizedTicket getTicketID(); 
    public IParameterizedTicket getDescription();    
    public IParameterizedTicket getExpectedEndDate() throws ParseException;
    public IParameterizedTicket getReporterID();
    public IParameterizedTicket getEmployeeID();
    public IParameterizedTicket getAssigneeName();
    public IParameterizedTicket getTicketType();
    public IParameterizedTicket getTicketStatus();
    public IParameterizedTicket getPriority();
    public IParameterizedTicket getUrgency();
    public IParameterizedTicket getImpact();
    public IParameterizedTicket getTicketLevel();
    public IParameterizedTicket getCustomerID();
    public IParameterizedTicket getCustomerName();
    public IParameterizedTicket getCreatorID();
    public IParameterizedTicket getCreatorName();
}
