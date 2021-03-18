package validations;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputStringValidationTest {
	
	@Test
	public void isStringNull() {
		InputStringValidationMock ticketStringValidation = new InputStringValidationMock();
		assertTrue(ticketStringValidation.isStringNull(" "));
		assertTrue(ticketStringValidation.isStringNull(""));
		assertFalse(ticketStringValidation.isStringNull("Ticket123"));
	}
	
	@Test
	public void isStringEmployeeAndReporterID() 
	{
		InputStringValidationMock ticketStringValidation = new InputStringValidationMock();
		assertTrue(ticketStringValidation.isStringEmployeeAndReporterID("Emp123"));
		assertFalse(ticketStringValidation.isStringEmployeeAndReporterID("123"));
		assertFalse(ticketStringValidation.isStringEmployeeAndReporterID("Employee124"));
	}
	
	@Test
	public void isStringContainsSpecialCharacters() {
		InputStringValidationMock ticketStringValidation = new InputStringValidationMock();
		assertTrue(ticketStringValidation.isStringContainsSpecialCharacters("J@nvi"));
		assertTrue(ticketStringValidation.isStringContainsSpecialCharacters("%Emp12"));
		assertTrue(ticketStringValidation.isStringContainsSpecialCharacters("Manager_44"));
		assertFalse(ticketStringValidation.isStringContainsSpecialCharacters("Develop new feature of ticket creation"));
	}
	
	@Test	
	public void isStringLengthValid() {
		InputStringValidationMock ticketStringValidation = new InputStringValidationMock();
		assertFalse(ticketStringValidation.isStringLengthValid("Ticket124", 5));
		assertTrue(ticketStringValidation.isStringLengthValid("Develop new feature of ticket creation", 50));
	}
}
