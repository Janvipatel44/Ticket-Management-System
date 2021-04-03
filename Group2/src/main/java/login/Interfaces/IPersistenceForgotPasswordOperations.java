package login.Interfaces;
public interface IPersistenceForgotPasswordOperations
{
    String getEmail(String employeeID);
    boolean updatePassword(String employeeID, String newPassword);
}
