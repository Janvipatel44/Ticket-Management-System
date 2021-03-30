package validations;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

public class InputDateValidationTest {

	@Test
	public void isDurationValid () throws ParseException 
	{
		InputDateValidationMock ticketStringValidation = new InputDateValidationMock();
		assertTrue(ticketStringValidation.isDurationValid("2020-01-01", "2020-01-01"));
		assertFalse(ticketStringValidation.isDurationValid("2020-01-01", "2019-12-23"));
		assertTrue(ticketStringValidation.isDurationValid("2020-01-01", "2020-01-05"));
		assertTrue(ticketStringValidation.isDurationValid("2020-01-01", "2021-01-05"));
	}

	@Test
	public void isDateFormatValid () throws ParseException 
	{
		InputDateValidationMock ticketStringValidation = new InputDateValidationMock();
		assertTrue(ticketStringValidation.isDateFormatValid("2020-01-01"));
		assertFalse(ticketStringValidation.isDateFormatValid("2020-13-01"));
		assertFalse(ticketStringValidation.isDateFormatValid("2020/01/01"));

	}
}
