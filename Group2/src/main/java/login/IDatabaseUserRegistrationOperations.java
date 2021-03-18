package login;
public interface IDatabaseUserRegistrationOperations
{
    boolean registerUserDatabase(User user, String user_password);
    boolean checkDuplicateEmployeeID(String employeeID);
}
