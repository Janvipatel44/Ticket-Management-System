package login.abstractFactory;
import login.Interfaces.IAuthenticationOperations;
import login.Interfaces.IPersistenceForgotPasswordOperations;
import login.Interfaces.IPersistenceUserRegistrationOperations;
import mailservice.IMail;
public abstract class LoginFactoryTest
{
    public abstract IAuthenticationOperations getAuthenticationOperationsMock();
    public abstract IMail getMailMock();
    public abstract IPersistenceForgotPasswordOperations getPersistenceForgotPasswordOperationsMock();
    public abstract IPersistenceUserRegistrationOperations getPersistenceUserRegistrationOperationsMock();
}
