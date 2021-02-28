package login;

import com.group2.userinterface.IInputOutputHandler;
import com.group2.userinterface.InputOutputHandler;
import database.AuthenticationOperations;
import database.IAuthenticationOperations;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class AuthenticationTest
{
    @Mock
    AuthenticationOperations authenticationOperations;

    @Test
    public void authenticateUserTest()
    {
        IInputOutputHandler inputOutputHandler = new InputOutputHandler();
        IEncryption iEncryption=null;
        IAuthenticationOperations iAuthenticationOperations=null;
        when(authenticationOperations.authenticateUser("111","Abcd@123")).thenReturn(true);
        Authentication authentication = new Authentication(iAuthenticationOperations, iEncryption, inputOutputHandler);

    }
}