package login.abstractFactory;
import login.Interfaces.*;
import mailservice.IMail;
import userinterface.IInputOutputHandler;

public abstract class LoginFactory
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
