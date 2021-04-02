package login;
import login.Interfaces.IForgotPassword;
import login.Interfaces.IPersistenceForgotPasswordOperations;
import mailservice.*;
import mailservice.interfaces.IMail;

import org.junit.Test;
import static org.junit.Assert.*;
public class ForgotPasswordTest
{
    IMail mail = new MailMock();
    IPersistenceForgotPasswordOperations forgotPasswordOperations = new PersistenceForgotPasswordOperationsMock();
    IForgotPassword forgotPassword = new ForgotPassword(mail,forgotPasswordOperations);

    public void sendOTPTest()
    {
        assertTrue("Forgot password mail - send OTP failed.", forgotPassword.sendOTP("EMP_123"));
    }

    @Test
    public void updatePasswordTest()
    {
        assertFalse("Update password failed for forgot password feature.", forgotPassword.updatePassword(3456, "dummy123"));
    }

}