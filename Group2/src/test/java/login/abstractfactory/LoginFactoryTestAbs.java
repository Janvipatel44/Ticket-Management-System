package login.abstractfactory;
import login.Interfaces.IAuthenticationOperations;
import login.Interfaces.IPersistenceForgotPasswordOperations;
import login.Interfaces.IPersistenceUserRegistrationOperations;
import mailservice.interfaces.IMail;
public abstract class LoginFactoryTestAbs
{
    public abstract IAuthenticationOperations getAuthenticationOperationsMock();
    public abstract IMail getMailMock();
    public abstract IPersistenceForgotPasswordOperations getPersistenceForgotPasswordOperationsMock();
    public abstract IPersistenceUserRegistrationOperations getPersistenceUserRegistrationOperationsMock();
}
