package database;
public interface IDatabaseLoginOperations
{

    public boolean registerUserDatabase(String employeeID, String firstName, String lastName, String email, String user_password, String user_type, IConnectionManager connection);
    public boolean checkDuplicateEmployeeID(String employeeID, IConnectionManager connection);

}
