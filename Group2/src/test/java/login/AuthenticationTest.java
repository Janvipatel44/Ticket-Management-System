package login;
import com.group2.userinterface.IInputOutputHandler;
import com.group2.userinterface.InputOutputHandler;
import database.ConnectionManager;
import database.IConnectionManager;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
public class AuthenticationTest
{
	IConnectionManager connection = new ConnectionManager("dumyfile.txt");
	IInputOutputHandler inputOutputHandler = new InputOutputHandler();
	IEncryption encryption= new Encryption();
	
    @Mock
    IAuthenticationOperations authenticationOperations = new AuthenticationOperations(connection);

    @Test
    public void authenticateUserTestSuccessfull()
    {      
        when(authenticationOperations.getPassword("111")).thenReturn("AcegD68:");
        Authentication authentication = new Authentication(authenticationOperations, encryption, inputOutputHandler);
        assertTrue("Test failed", authentication.authenticateUser("111", "Abcd@123"));
    }
    
    @Test
    public void authenticateUserTestUnsuccessfull()
    {
        when(authenticationOperations.getPassword("112")).thenReturn("BcygD67&");
        Authentication authentication = new Authentication(authenticationOperations, encryption, inputOutputHandler);
        assertFalse("Test failed", authentication.authenticateUser("112", "Abcd@123"));
    }
    
    @Test
    public void authenticateUserTestInvalidUser()
    {
        when(authenticationOperations.getPassword("113")).thenReturn("AcegD68:");
        Authentication authentication = new Authentication(authenticationOperations, encryption, inputOutputHandler);
        assertFalse("Test failed", authentication.authenticateUser("113", "Abcd@123"));
    }
}