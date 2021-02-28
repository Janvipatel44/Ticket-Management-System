package database;
public class AuthenticationOperationsMock
{
    private final String demo_user = "111";

    public boolean authenticateUser(String employeeID, String user_password)
    {
        if(employeeID.equals(demo_user))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
