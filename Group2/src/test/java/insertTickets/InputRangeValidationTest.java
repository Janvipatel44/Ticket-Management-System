package insertTickets;

import static org.junit.Assert.*;

import org.junit.Test;

import insertTicket.Interfaces.IInputRangeValidation;
import insertTickets.abstractfactory.IInsertTicketTestFactory;
import insertTickets.abstractfactory.InsertTicketTestFactory;

public class InputRangeValidationTest 
{
	IInsertTicketTestFactory insertTicketTestFactory = InsertTicketTestFactory.instance();
	IInputRangeValidation rangeValidation = insertTicketTestFactory.rangeValidation();

	@Test
	public void isRangeValid ()  
	{
		assertFalse(rangeValidation.isRangeValid(30));
		assertTrue(rangeValidation.isRangeValid(1));
		assertTrue(rangeValidation.isRangeValid(5));
		assertFalse(rangeValidation.isRangeValid(0));
	}

}
