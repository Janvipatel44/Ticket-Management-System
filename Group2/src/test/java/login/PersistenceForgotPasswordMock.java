package login;
import login.Interfaces.IPersistenceForgotPasswordOperations;
public class PersistenceForgotPasswordMock implements IPersistenceForgotPasswordOperations
{
    public String getEmail(String employeeID)
    {
        return "dummy@gmail.com";
    }

    public boolean updatePassword(String employeeID, String newPassword)
    {
        return true;
    }
}
