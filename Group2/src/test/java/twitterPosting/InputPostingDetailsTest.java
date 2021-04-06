package twitterPosting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import login.Authentication;
import login.Interfaces.IPersistenceAuthenticationOperations;
import login.abstractfactory.ILoginFactoryTest;
import login.abstractfactory.LoginFactoryTest;

public class InputPostingDetailsTest 
{
	 ILoginFactoryTest loginFactoryTest = LoginFactoryTest.instance();
	 IPersistenceAuthenticationOperations authenticationOperations;
	 @Before
     public void initialize()
     {
        authenticationOperations = loginFactoryTest.getAuthenticationOperationsMock();
     }

     @Test
     public void authenticateUserTestSuccessfull()
     {
        Authentication authentication = new Authentication(authenticationOperations);
        assertTrue("Test failed", authentication.authenticateUser("111", "Abcd@123"));
     }
}
