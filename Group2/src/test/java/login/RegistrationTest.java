package login;
import static org.junit.Assert.*;
import org.junit.Test;
import database.ConnectionManager;
import database.IConnectionManager;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;
import login.Interfaces.*;
public class RegistrationTest
{
	IConnectionManager connection = new ConnectionManager("ConfigurationFile.txt");
	IEncryption encryption= new Encryption();
	IInputOutputHandler inputOutputHandler = new InputOutputHandler();
	IPersistenceUserRegistrationOperations databaseUserMock = new PersistenceUserRegistrationOperationsMock();
	
	@Test
	public void registerUserTestSuccessfull()
	{
		IParameterizedUser user = new ParameterizedUser("111", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);
		assertTrue("Test failed.", registration.registerUser(user, "Abcd@123"));
	}
	
	@Test
	public void registerUserTestUnsuccessfull_Duplicate()
	{
		IParameterizedUser user = new ParameterizedUser("112", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);
		assertFalse("Test failed.", registration.registerUser(user, "Abcd@123"));
	}
	
	@Test
	public void registerUserTestUnsuccessfull_SQLIssue()
	{
		IParameterizedUser user = new ParameterizedUser("113", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);
		assertFalse("Test failed.", registration.registerUser(user, "Abcd@123"));
	}

	@Test
	public void checkPasswordRules()
	{

		IParameterizedUser user_one = new ParameterizedUser("114", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IParameterizedUser user_two = new ParameterizedUser("115", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IParameterizedUser user_three = new ParameterizedUser("116", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);

		assertFalse("Test failed.", registration.registerUser(user_one, "abcd@123"));
		
		assertFalse("Test failed.", registration.registerUser(user_one, "ABCD@123"));
		
		assertFalse("Test failed.", registration.registerUser(user_one, "ABCD@abcd"));
		
		assertFalse("Test failed.", registration.registerUser(user_one, "ADa1@"));
		
		assertFalse("Test failed.", registration.registerUser(user_one, "ADa112349"));

	}
}