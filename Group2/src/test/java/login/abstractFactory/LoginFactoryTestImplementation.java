package login.abstractFactory;
import login.AuthenticationOperationsMock;
import login.Interfaces.IAuthenticationOperations;
import login.Interfaces.IPersistenceForgotPasswordOperations;
import login.Interfaces.IPersistenceUserRegistrationOperations;
import mailservice.interfaces.IMail;
import login.MailMock;
import login.PersistenceForgotPasswordOperationsMock;
import login.PersistenceUserRegistrationOperationsMock;
public class LoginFactoryTestImplementation extends LoginFactoryTest
{
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
