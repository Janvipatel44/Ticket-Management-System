package insertTicket;

import insertTicket.Interfaces.IInputStringValidation;

public class InputStringValidation implements IInputStringValidation
{

	protected static String validationString = null;
	protected static int length = 0;
	
	public boolean isStringNull(String validationString) {
		
		if(validationString == null || validationString.equals(" "))  {
			System.out.print("Null value found for input string");
			return true;
		}
		
		return false;
	}
	
	public boolean isStringContainsSpecialCharacters (String validationString) {
		
		if(validationString.contains("@") || validationString.contains("#") || validationString.contains("!") ||  validationString.contains("_") ||  validationString.contains("%") || validationString.contains("&"))
		{
			System.out.print("SpecialCharacters found for input string");
			return true;
		}
		
		return false;
	}

	public boolean isStringEmployeeAndReporterID (String validationString) {
		
		String prefix = "EMP";
		if(validationString.equals(null) || validationString.equals(" ") || validationString.equals("")) {
			return true;
		}
		if(validationString.substring(0, 3).equalsIgnoreCase(prefix) ) {
			if(validationString.substring(3, validationString.length()).matches("[0-9]+"))
			{
				return true;
			}
		}
		System.out.print("\nPrefix should be 'EMP' for input string");
		return false;
	}

	public boolean isStringLengthValid (String validationString, int length) {
	
			if(validationString.length()<=length)
			{
				return true;
			}
			System.out.print("Length Exceeded for input string");
			return false;
	}
}
