package login;
import static org.junit.Assert.*;
import login.Interfaces.IEncryption;
import login.Interfaces.IParameterizedUser;
import login.Interfaces.IPersistenceUserRegistrationOperations;
import login.Interfaces.IRegister;
import org.junit.Test;
import database.ConnectionManager;
import database.IConnectionManager;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class RegistrationTest
{
	IConnectionManager connection = new ConnectionManager("ConfigurationFile.txt");
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
		ParameterizedUser user = new ParameterizedUser("111", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);
		assertFalse("Test failed.", registration.registerUser(user, "Abcd@123"));
	}

	@Test
	public void checkPasswordRules()
	{
		IParameterizedUser user_one = new ParameterizedUser("114", "Daniel", "Howards", "custom@gmail.com", "End_User");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler, encryption);

		assertFalse("Test failed.", registration.registerUser(user_one, "abcd@123"));

		assertFalse("Test failed.", registration.registerUser(user_one, "ABCD@123"));

		assertFalse("Test failed.", registration.registerUser(user_one, "ABCD@abcd"));

		assertFalse("Test failed.", registration.registerUser(user_one, "ADa1@"));

		assertFalse("Test failed.", registration.registerUser(user_one, "ADa112349"));

	}
}