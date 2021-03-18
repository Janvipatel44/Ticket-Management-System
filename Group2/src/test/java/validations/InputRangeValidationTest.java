package validations;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputRangeValidationTest {

	@Test
	public void isRangeValid ()  
	{
		InputRangeValidationMock rangeValidationMock = new InputRangeValidationMock();
		assertFalse(rangeValidationMock.isRangeValid(30));
		assertTrue(rangeValidationMock.isRangeValid(1));
		assertTrue(rangeValidationMock.isRangeValid(5));
		assertFalse(rangeValidationMock.isRangeValid(0));
	}

}
