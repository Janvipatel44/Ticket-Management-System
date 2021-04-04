package login.abstractfactory;
import login.AuthenticationOperationsMock;
import login.Interfaces.*;
import mailservice.interfaces.IMail;
import login.MailMock;
import login.PersistenceForgotPasswordOperationsMock;
import login.PersistenceUserRegistrationOperationsMock;
public class LoginFactoryTest implements ILoginFactoryTest
{
    private static ILoginFactoryTest uniqueInstance = null;

    private LoginFactoryTest()
    {

    }

    public static ILoginFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new LoginFactoryTest();
        }
        return uniqueInstance;
    }

    public IAuthenticationOperations getAuthenticationOperationsMock()
    {
        return new AuthenticationOperationsMock();
    }

    public IMail getMailMock()
    {
        return new MailMock();
    }

    public IPersistenceForgotPasswordOperations getPersistenceForgotPasswordOperationsMock()
    {
        return new PersistenceForgotPasswordOperationsMock();
    }

    public IPersistenceUserRegistrationOperations getPersistenceUserRegistrationOperationsMock()
    {
        return new PersistenceUserRegistrationOperationsMock();
    }
}
