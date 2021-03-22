package login;
import login.Interfaces.*;
public class PersistenceUserRegistrationOperationsMock implements IPersistenceUserRegistrationOperations
{
    public boolean registerUserDatabase(ParameterizedUser user, String user_password)
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
