package login;
import com.group2.userinterface.IInputOutputHandler;
import com.group2.userinterface.InputOutputHandler;
import org.junit.Test;
import static org.junit.Assert.*;
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