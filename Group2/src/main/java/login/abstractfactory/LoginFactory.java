package login.abstractfactory;
import login.*;
import login.Interfaces.*;
import mailservice.interfaces.IMail;
import userinterface.IInputOutputHandler;

import java.io.IOException;

public class LoginFactory implements ILoginFactory
{
    private static ILoginFactory uniqueInstance = null;

    private LoginFactory()
    {

    }

    public static ILoginFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new LoginFactory();
        }
        return uniqueInstance;
    }

    public IAuthentication getAuthentication(IPersistenceAuthenticationOperations authenticationOperations)
    {
        return new Authentication(authenticationOperations);
    }

    public IPersistenceAuthenticationOperations getAuthenticationOperations()
    {
        return new PersistenceAuthenticationOperations();
    }

    public IEncryption getEncryption()
    {
        return new Encryption();
    }

    public IForgotPassword getForgotPassword(IMail mail, IPersistenceForgotPasswordOperations persistenceForgotPasswordOperations)
    {
        return new ForgotPassword(mail, persistenceForgotPasswordOperations);
    }

    public IParameterizedUser getParameterizedUser(String employeeID, String firstName, String lastName, String email, String user_type)
    {
        return new ParameterizedUser(employeeID, firstName, lastName, email, user_type);
    }

    public IPasswordValidations getPasswordValidations()
    {
        return new PasswordValidations();
    }

    public IPersistenceForgotPasswordOperations getPersistenceForgotPasswordOperations() throws IOException {
        return new PersistenceForgotPasswordOperations();
    }

    public IPersistenceUserRegistrationOperations getPersistenceUserRegistrationOperations()
    {
        return new PersistenceUserRegistrationOperations();
    }

    public IRegister getRegister(IPersistenceUserRegistrationOperations userRegistrationOperations, IInputOutputHandler inputOutputHandler)
    {
        return new Registration(userRegistrationOperations, inputOutputHandler);
    }
}
