package database;
public interface IAuthenticationOperations
{
    boolean authenticateUser(String employeeID, String user_password);
}
