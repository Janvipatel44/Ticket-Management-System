package login.abstractfactory;
import login.Interfaces.IAuthenticationDao;
import login.Interfaces.IForgotPasswordDao;
import login.Interfaces.IUserRegistrationDao;
import mailservice.interfaces.IMail;
public abstract class LoginFactoryTestAbs
{
    public abstract IAuthenticationDao getAuthenticationOperationsMock();
    public abstract IMail getMailMock();
    public abstract IForgotPasswordDao getPersistenceForgotPasswordOperationsMock();
    public abstract IUserRegistrationDao getPersistenceUserRegistrationOperationsMock();
}
