package login;
import org.junit.Test;
import userinterface.*;
import static org.junit.Assert.*;
import login.Interfaces.*;
public class AuthenticationTest
{
	IInputOutputHandler inputOutputHandler = new InputOutputHandler();
	IEncryption encryption= new Encryption();
	IAuthenticationOperations authenticationOperations = new AuthenticationOperationsMock();

    @Test
    public void authenticateUserTestSuccessfull()
    {
        Authentication authentication = new Authentication(authenticationOperations, encryption, inputOutputHandler);
        assertTrue("Test failed", authentication.authenticateUser("111", "Abcd@123"));
    }
    
    @Test
    public void authenticateUserTestUnsuccessfull()
    {
        Authentication authentication = new Authentication(authenticationOperations, encryption, inputOutputHandler);
        assertFalse("Test failed", authentication.authenticateUser("112", "Abcd@12345"));
    }
}