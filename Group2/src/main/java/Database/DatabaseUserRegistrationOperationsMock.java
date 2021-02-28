package database;
public class DatabaseUserRegistrationOperationsMock
{
    private final String demo_user = "111";

    public boolean registerUserDatabase(String employeeID, String firstName, String lastName, String email, String user_password, String user_type, IConnectionManager connection)
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

    public boolean checkDuplicateEmployeeID(String employeeID) {
        if (employeeID.equals(demo_user))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
