package login.abstractfactory;
import login.Interfaces.IPersistenceAuthenticationOperations;
import login.Interfaces.IPersistenceForgotPasswordOperations;
import login.Interfaces.IPersistenceUserRegistrationOperations;
import mailservice.interfaces.IMail;
public abstract class LoginFactoryTestAbs
{
    public abstract IPersistenceAuthenticationOperations getAuthenticationOperationsMock();
    public abstract IMail getMailMock();
    public abstract IPersistenceForgotPasswordOperations getPersistenceForgotPasswordOperationsMock();
    public abstract IPersistenceUserRegistrationOperations getPersistenceUserRegistrationOperationsMock();
}
