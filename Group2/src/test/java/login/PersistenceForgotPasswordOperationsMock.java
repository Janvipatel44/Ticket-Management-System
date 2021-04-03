package login;
import login.Interfaces.IPersistenceForgotPasswordOperations;
public class PersistenceForgotPasswordOperationsMock implements IPersistenceForgotPasswordOperations
{
    public String getEmail(String employeeID)
    {
        return "dummy@gmail.com";
    }

    public boolean updatePassword(String employeeID, String newPassword)
    {
        return false;
    }
}
