package login;
<<<<<<< HEAD
import com.group2.userinterface.IInputOutputHandler;
=======
import database.IDatabaseUserRegistrationOperations;
import userinterface.IInputOutputHandler;
>>>>>>> 1e4b70c55d45bf67f1e1a37d6da192802147005b
public class Registration implements IRegister
{
    private final IDatabaseUserRegistrationOperations userRegistrationOperations;
    private final IInputOutputHandler inputOutputHandler;
    private final IEncryption encryption;
    private boolean result = false;

    public Registration(IDatabaseUserRegistrationOperations userRegistrationOperations, IInputOutputHandler inputOutputHandler, IEncryption encryption)
    {
        this.userRegistrationOperations = userRegistrationOperations;
        this.inputOutputHandler = inputOutputHandler;
        this.encryption = encryption;
    }

    public boolean registerUser(User user, String user_password)
    {
        if(userRegistrationOperations.checkDuplicateEmployeeID(user.getEmployeeID()))
        {
            inputOutputHandler.displayMethod("Error: Duplicate employee ID found. Please use a different employee ID and try again.");
            result = false;
            return result;
        }
        else
        {
            if(checkUpperCaseRule(user_password) && checkLowerCaseRule(user_password) && checkNumberRule(user_password) && checkSpecialCharacterRule(user_password) && checkLengthRule(user_password))
            {

                String encrypted_password = encryption.encryptPassword(user_password);
                result = userRegistrationOperations.registerUserDatabase(user, encrypted_password);
                return result;
            }
            else
            {
				System.out.println(checkUpperCaseRule(user_password));
				System.out.println(checkLowerCaseRule(user_password));
				System.out.println(checkNumberRule(user_password));
				System.out.println(checkSpecialCharacterRule(user_password));
				System.out.println(checkLengthRule(user_password));
                inputOutputHandler.displayMethod("Error: Password does not match the requirements. \nA password must be at least 8 characters, must contain a special character (@,!,#,$,%,&,*), must be 8 to 100 characters in length, must contain at least one lower case and one upper case letter");
                return result = false;
            }
        }
    }
    
    private boolean checkUpperCaseRule(String user_password)
    {
    	boolean upperCaseResult = false;
    	int lowerThreshold = 65;
    	int higherThreshold = 90;
    	for(int i=0;i<user_password.length();i++)
    	{
    		char c = user_password.charAt(i);
    		if(c>=lowerThreshold && c<=higherThreshold)
    		{
    			upperCaseResult = true;
    			return upperCaseResult;
    		}
    	}
    	return upperCaseResult;
    }
    
    private boolean checkLowerCaseRule(String user_password)
    {
    	boolean lowerCaseResult = false;
    	int lowerThreshold = 97;
    	int higherThreshold = 122;
    	for(int i=0;i<user_password.length();i++)
    	{
			char c = user_password.charAt(i);
    		if(c>=lowerThreshold && c<=higherThreshold)
    		{
    			lowerCaseResult = true;
    			return lowerCaseResult;
    		}
    	}
    	return lowerCaseResult;
    }
    
    private boolean checkNumberRule(String user_password)
    {
    	boolean checkNumberResult = false;
    	int lowerThreshold = 48;
    	int higherThreshold = 57;
    	for(int i=0;i<user_password.length();i++)
    	{
			char c = user_password.charAt(i);
    		if(c>=lowerThreshold && c<=higherThreshold)
    		{
    			checkNumberResult = true;
    			return checkNumberResult;
    		}
    	}
    	return checkNumberResult;
    }
    
    private boolean checkSpecialCharacterRule(String user_password)
    {
    	boolean checkSpecialCharacterResult = false;
    	int lowerThreshold_first = 33;
    	int higherThreshold_first = 47;
    	int lowerThreshold_second = 58;
    	int higherThreshold_second = 64;
    	int lowerThreshold_third = 91;
    	int higherThreshold_third = 96;
    	int lowerThreshold_fourth = 123;
    	int higherThreshold_fourth = 126;
    	
    	for(int i=0;i<user_password.length();i++)
    	{
			char c = user_password.charAt(i);
    		if((c>=lowerThreshold_first && c<=higherThreshold_first) ||
    		   (c>=lowerThreshold_second && c<=higherThreshold_second) ||
    		   (c>=lowerThreshold_third && c<=higherThreshold_third) ||
    		   (c>=lowerThreshold_fourth && c<=higherThreshold_fourth))
    		{
    			checkSpecialCharacterResult = true;
    			return checkSpecialCharacterResult;
    		}
    	}
    	return checkSpecialCharacterResult;
    }
    
    private boolean checkLengthRule(String user_password)
    {
    	boolean checkLengthResult = false;
    	int minLength = 8;
    	int maxLength = 100;
    
    	if(user_password.length()>=minLength && user_password.length()<=maxLength)
    	{
    		checkLengthResult = true;
    		return checkLengthResult;
    	}
    	return checkLengthResult;
    }
}