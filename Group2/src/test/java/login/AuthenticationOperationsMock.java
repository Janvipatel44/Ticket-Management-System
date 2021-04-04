package login;
import login.Interfaces.IPersistenceAuthenticationOperations;
public class AuthenticationOperationsMock implements IPersistenceAuthenticationOperations
{
    public String getPassword(String employeeID) {
        return "AcegD68:";
    }
}
