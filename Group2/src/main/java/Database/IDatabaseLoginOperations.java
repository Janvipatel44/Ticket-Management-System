package Database;
public interface IDatabaseLoginOperations
{
    public boolean registerUserDatabase(String employeeID, String firstName, String lastName, String email, String user_password, String user_type, IDatabaseConnection connection);
    public boolean checkDuplicateEmployeeID(String employeeID, IDatabaseConnection connection);

}
