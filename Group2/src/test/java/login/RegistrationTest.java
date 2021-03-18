package login;
import static org.junit.Assert.*;
import org.junit.Test;
import userinterface.*;
public class RegistrationTest
{
	
	IInputOutputHandler inputOutputHandler = new InputOutputHandler();
	IEncryption encryption= new Encryption();
	IDatabaseUserRegistrationOperations databaseUserMock = new DatabaseUserRegistrationOperationsMock();
	
	@Test
	public void registerUserTestSuccessfull()
	{		
		User user = new User("111", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);
		assertTrue("Test failed.", registration.registerUser(user, "Abcd@123"));
	}
	
	@Test
	public void registerUserTestUnsuccessfull_Duplicate()
	{
		User user = new User("112", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);
		assertFalse("Test failed.", registration.registerUser(user, "Abcd@123"));
	}

	@Test
	public void checkPasswordRules()
	{
		User user_one = new User("114", "Daniel", "Howards", "custom@gmail.com", "End_User");
		User user_two = new User("115", "Daniel", "Howards", "custom@gmail.com", "End_User");
		User user_three = new User("116", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);

	//	assertTrue("Test failed.", registration.registerUser(user_one, "Abcd@123"));

		assertFalse("Test failed.", registration.registerUser(user_two, "abcd@123"));
		
		assertFalse("Test failed.", registration.registerUser(user_three, "ABCD@123"));
		
		assertFalse("Test failed.", registration.registerUser(user_three, "ABCD@abcd"));
		
		assertFalse("Test failed.", registration.registerUser(user_three, "ADa1@"));
		
		assertFalse("Test failed.", registration.registerUser(user_three, "ADa112349"));

	}
}