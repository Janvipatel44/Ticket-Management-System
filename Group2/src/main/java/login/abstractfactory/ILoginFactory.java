package login.abstractfactory;
import login.Interfaces.*;
import mailservice.interfaces.IMail;
import userinterface.IInputOutputHandler;

import java.io.IOException;

public interface ILoginFactory
{
    IAuthentication getAuthentication(IPersistenceAuthenticationOperations authenticationOperations);
    IPersistenceAuthenticationOperations getAuthenticationOperations();
    IEncryption getEncryption();
    IForgotPassword getForgotPassword(IMail mail, IPersistenceForgotPasswordOperations persistenceForgotPasswordOperations);
    IParameterizedUser getParameterizedUser(String employeeID, String firstName, String lastName, String email, String user_type);
    IPasswordValidations getPasswordValidations();
    IPersistenceForgotPasswordOperations getPersistenceForgotPasswordOperations();
    IPersistenceUserRegistrationOperations getPersistenceUserRegistrationOperations();
    IRegister getRegister(IPersistenceUserRegistrationOperations userRegistrationOperations, IInputOutputHandler inputOutputHandler);
}
