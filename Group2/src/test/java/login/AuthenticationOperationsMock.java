package login;
import login.Interfaces.*;
public class AuthenticationOperationsMock implements IAuthenticationOperations
{
    public String getPassword(String employeeID)
    {
       return "AcegD68:";
    }
}
