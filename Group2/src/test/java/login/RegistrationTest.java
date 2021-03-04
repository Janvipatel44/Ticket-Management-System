package login;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mock;
import com.group2.userinterface.IInputOutputHandler;
import com.group2.userinterface.InputOutputHandler;
import database.ConnectionManager;
import static org.mockito.Mockito.when;
import database.IConnectionManager;
public class RegistrationTest
{
	IConnectionManager connection = new ConnectionManager("dumyfile.txt");
	IInputOutputHandler inputOutputHandler = new InputOutputHandler();
	IEncryption encryption= new Encryption();
	
	@Mock
    IDatabaseUserRegistrationOperations databaseUserRegistrationOperations = new DatabaseUserRegistrationOperations(connection);

	@Test
	public void registerUserTestSuccessfull()
	{
		User user = new User("111", "Daniel", "Howards", "custom@gmail.com", "End_User");

		when(databaseUserRegistrationOperations.checkDuplicateEmployeeID("111")).thenReturn(false);
		when(databaseUserRegistrationOperations.registerUserDatabase(user, "Abcd@123")).thenReturn(true);
		IRegister registration = new Registration(databaseUserRegistrationOperations, inputOutputHandler, encryption);
		assertTrue("Test failed.", registration.registerUser(user, "Abcd@123"));
	}
	
	@Test
	public void registerUserTestUnsuccessfull_Duplicate()
	{
		User user = new User("112", "Daniel", "Howards", "custom@gmail.com", "End_User");

		when(databaseUserRegistrationOperations.checkDuplicateEmployeeID("112")).thenReturn(true);
		when(databaseUserRegistrationOperations.registerUserDatabase(user, "Abcd@123")).thenReturn(true);
		IRegister registration = new Registration(databaseUserRegistrationOperations, inputOutputHandler, encryption);
		assertFalse("Test failed.", registration.registerUser(user, "Abcd@123"));
	}
	
	@Test
	public void registerUserTestUnsuccessfull_SQLIssue()
	{
		User user = new User("113", "Daniel", "Howards", "custom@gmail.com", "End_User");

		when(databaseUserRegistrationOperations.checkDuplicateEmployeeID("113")).thenReturn(false);
		when(databaseUserRegistrationOperations.registerUserDatabase(user, "Abcd@123")).thenReturn(false);
		IRegister registration = new Registration(databaseUserRegistrationOperations, inputOutputHandler, encryption);
		assertFalse("Test failed.", registration.registerUser(user, "Abcd@123"));
	}
	
	@Test
	public void checkPasswordRules()
	{
		User user_one = new User("114", "Daniel", "Howards", "custom@gmail.com", "End_User");
		User user_two = new User("115", "Daniel", "Howards", "custom@gmail.com", "End_User");
		User user_three = new User("116", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserRegistrationOperations, inputOutputHandler, encryption);

		when(databaseUserRegistrationOperations.checkDuplicateEmployeeID("114")).thenReturn(false);
		assertTrue("Test failed.", registration.registerUser(user_one, "Abcd@123"));
		
		when(databaseUserRegistrationOperations.checkDuplicateEmployeeID("115")).thenReturn(false);
		assertTrue("Test failed.", registration.registerUser(user_two, "abcd@123"));
		
		when(databaseUserRegistrationOperations.checkDuplicateEmployeeID("116")).thenReturn(false);
		assertTrue("Test failed.", registration.registerUser(user_three, "ABCD@123"));
		
		when(databaseUserRegistrationOperations.checkDuplicateEmployeeID("117")).thenReturn(false);
		assertTrue("Test failed.", registration.registerUser(user_three, "ABCD@abcd"));
		
		when(databaseUserRegistrationOperations.checkDuplicateEmployeeID("118")).thenReturn(false);
		assertTrue("Test failed.", registration.registerUser(user_three, "ADa1@"));
		
		when(databaseUserRegistrationOperations.checkDuplicateEmployeeID("119")).thenReturn(false);
		assertTrue("Test failed.", registration.registerUser(user_three, "ADa112349"));

	}
}