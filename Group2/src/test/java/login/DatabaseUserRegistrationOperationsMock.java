package login;
public class DatabaseUserRegistrationOperationsMock implements IDatabaseUserRegistrationOperations
{
    public boolean registerUserDatabase(User user, String user_password)
    {
        if(user.getEmployeeID().equals("111"))
        {
            return true;
        }
        return false;
    }

    public boolean checkDuplicateEmployeeID(String employeeID)
    {
        if(employeeID.equals("111"))
        {
            return false;
        }
        return true;
    }
}
