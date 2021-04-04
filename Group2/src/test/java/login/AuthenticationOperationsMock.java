package login;
import login.Interfaces.IParameterizedUser;
import login.Interfaces.IPersistenceAuthenticationOperations;
public class AuthenticationOperationsMock implements IPersistenceAuthenticationOperations
{
    public String getPassword(String employeeID) {
        return "AcegD68:";
    }

    public IParameterizedUser getUserDetails(String employeeID)
    {
        return null;
    }
}
