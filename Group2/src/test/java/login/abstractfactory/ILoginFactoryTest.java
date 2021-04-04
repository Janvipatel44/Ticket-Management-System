package login.abstractfactory;
import login.Interfaces.*;
import mailservice.interfaces.IMail;
public interface ILoginFactoryTest
{
    IPersistenceAuthenticationOperations getAuthenticationOperationsMock();
    IMail getMailMock();
    IPersistenceForgotPasswordOperations getPersistenceForgotPasswordOperationsMock();
    IPersistenceUserRegistrationOperations getPersistenceUserRegistrationOperationsMock();
}
