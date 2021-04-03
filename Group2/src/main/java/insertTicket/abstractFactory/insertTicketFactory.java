package insertTicket.abstractFactory;

import java.text.ParseException;

import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.Interfaces.IParameterizedTicket;
import insertTicket.Interfaces.IUserInputValidation;

public class insertTicketFactory implements IinsertTicketFactory {
	private static IinsertTicketFactory uniqueInstance = null;

    private insertTicketFactory()
    {

    }

    public static IinsertTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new insertTicketFactory();
        }
        return uniqueInstance;
    }
	@Override
	public 	IUserInputValidation validateInsertion() throws ParseException {
		// TODO Auto-generated method stub
		return validateInsertion();
	}

	@Override
	public IInsertTicket successfulInsertion() throws ParseException {
		// TODO Auto-generated method stub
		return successfulInsertion();
	}

	@Override
	public IInputDateValidation isDurationValid(String startDate, String endDate) throws ParseException {
		// TODO Auto-generated method stub
		return isDurationValid( startDate,  endDate);
	}

	@Override
	public IInputDateValidation isDateFormatValid(String validationString) throws ParseException {
		// TODO Auto-generated method stub
		return isDateFormatValid( validationString);
	}

	@Override
	public IInputRangeValidation isRangeValid(int inputValue) {
		// TODO Auto-generated method stub
		return isRangeValid( inputValue);
	}

	@Override
	public IInputStringValidation isStringNull(String validationString) {
		// TODO Auto-generated method stub
		return isStringNull( validationString) ;
	}

	@Override
	public IInputStringValidation isStringContainsSpecialCharacters(String validationString) {
		// TODO Auto-generated method stub
		return isStringContainsSpecialCharacters( validationString);
	}

	@Override
	public IInputStringValidation isStringEmployeeAndReporterID(String validationString) {
		// TODO Auto-generated method stub
		return isStringEmployeeAndReporterID( validationString);
	}

	@Override
	public IInputStringValidation isStringLengthValid(String validationString, int length) {
		// TODO Auto-generated method stub
		return isStringLengthValid( validationString,  length);
	}

	@Override
	public IInsertTicket userInputTicketDetails() throws ParseException {
		// TODO Auto-generated method stub
		return userInputTicketDetails();
	}

	@Override
	public IParameterizedTicket getTicketID() {
		// TODO Auto-generated method stub
		return getTicketID();
	}

	@Override
	public IParameterizedTicket getDescription() {
		// TODO Auto-generated method stub
		return getDescription();
	}

	@Override
	public IParameterizedTicket getExpectedEndDate() throws ParseException {
		// TODO Auto-generated method stub
		return getExpectedEndDate();
	}

	@Override
	public IParameterizedTicket getReporterID() {
		// TODO Auto-generated method stub
		return getReporterID();
	}

	@Override
	public IParameterizedTicket getEmployeeID() {
		// TODO Auto-generated method stub
		return getEmployeeID() ;
	}

	@Override
	public IParameterizedTicket getAssigneeName() {
		// TODO Auto-generated method stub
		return getAssigneeName();
	}

	@Override
	public IParameterizedTicket getTicketType() {
		// TODO Auto-generated method stub
		return getTicketType();
	}

	@Override
	public IParameterizedTicket getTicketStatus() {
		// TODO Auto-generated method stub
		return getTicketStatus() ;
	}

	@Override
	public IParameterizedTicket getPriority() {
		// TODO Auto-generated method stub
		return getPriority();
	}

	@Override
	public IParameterizedTicket getUrgency() {
		// TODO Auto-generated method stub
		return getUrgency();
	}

	@Override
	public IParameterizedTicket getImpact() {
		// TODO Auto-generated method stub
		return getImpact();
	}

	@Override
	public IParameterizedTicket getTicketLevel() {
		// TODO Auto-generated method stub
		return getTicketLevel() ;
	}

	@Override
	public IParameterizedTicket getCustomerID() {
		// TODO Auto-generated method stub
		return getCustomerID();
	}

	@Override
	public IParameterizedTicket getCustomerName() {
		// TODO Auto-generated method stub
		return getCustomerName();
	}

	@Override
	public IParameterizedTicket getCreatorID() {
		// TODO Auto-generated method stub
		return getCreatorID();
	}

	@Override
	public IParameterizedTicket getCreatorName() {
		// TODO Auto-generated method stub
		return getCreatorName();
	}
}
