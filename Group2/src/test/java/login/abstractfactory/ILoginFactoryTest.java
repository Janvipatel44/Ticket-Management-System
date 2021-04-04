package login.abstractfactory;
import login.Interfaces.*;
import mailservice.interfaces.IMail;
public interface ILoginFactoryTest
{
    IAuthenticationOperations getAuthenticationOperationsMock();
    IMail getMailMock();
    IPersistenceForgotPasswordOperations getPersistenceForgotPasswordOperationsMock();
    IPersistenceUserRegistrationOperations getPersistenceUserRegistrationOperationsMock();
}
