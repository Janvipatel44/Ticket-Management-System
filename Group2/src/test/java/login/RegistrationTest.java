package login;
import static org.junit.Assert.*;
import org.junit.Test;
import userinterface.*;
import login.Interfaces.*;
public class RegistrationTest
{
	
	IInputOutputHandler inputOutputHandler = new InputOutputHandler();
	IEncryption encryption= new Encryption();
	IPersistenceUserRegistrationOperations databaseUserMock = new PersistenceUserRegistrationOperationsMock();
	
	@Test
	public void registerUserTestSuccessfull()
	{		
		ParameterizedUser user = new ParameterizedUser("111", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);
		assertTrue("Test failed.", registration.registerUser(user, "Abcd@123"));
	}
	
	@Test
	public void registerUserTestUnsuccessfull_Duplicate()
	{
		ParameterizedUser user = new ParameterizedUser("112", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);
		assertFalse("Test failed.", registration.registerUser(user, "Abcd@123"));
	}

	@Test
	public void checkPasswordRules()
	{
		ParameterizedUser user_one = new ParameterizedUser("114", "Daniel", "Howards", "custom@gmail.com", "End_User");
		ParameterizedUser user_two = new ParameterizedUser("115", "Daniel", "Howards", "custom@gmail.com", "End_User");
		ParameterizedUser user_three = new ParameterizedUser("116", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);

		assertFalse("Test failed.", registration.registerUser(user_two, "abcd@123"));
		
		assertFalse("Test failed.", registration.registerUser(user_three, "ABCD@123"));
		
		assertFalse("Test failed.", registration.registerUser(user_three, "ABCD@abcd"));
		
		assertFalse("Test failed.", registration.registerUser(user_three, "ADa1@"));
		
		assertFalse("Test failed.", registration.registerUser(user_three, "ADa112349"));

	}
}