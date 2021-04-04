package login.abstractfactory;
import login.Interfaces.*;
import mailservice.interfaces.IMail;
import userinterface.IInputOutputHandler;

public abstract class LoginFactoryAbs
{
    public abstract IAuthentication getAuthentication(IAuthenticationOperations authenticationOperations);
    public abstract IAuthenticationOperations getAuthenticationOperations();
    public abstract IEncryption getEncryption();
    public abstract IForgotPassword getForgotPassword(IMail mail, IPersistenceForgotPasswordOperations persistenceForgotPasswordOperations);
    public abstract IParameterizedUser getParameterizedUser(String employeeID, String firstName, String lastName, String email, String user_type);
    public abstract IPasswordValidations getPasswordValidations();
    public abstract IPersistenceForgotPasswordOperations getPersistenceForgotPasswordOperations();
    public abstract IPersistenceUserRegistrationOperations getPersistenceUserRegistrationOperations();
    public abstract IRegister getRegister(IPersistenceUserRegistrationOperations userRegistrationOperations, IInputOutputHandler inputOutputHandler);
}
