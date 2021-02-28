package database;

public interface IDatabaseUserRegistrationOperations
{
    boolean registerUserDatabase(String employeeID, String firstName, String lastName, String email, String user_password, String user_type);
    boolean checkDuplicateEmployeeID(String employeeID);
}
