package login.Interfaces;
public interface IPersistenceUserRegistrationOperations
{
    boolean registerUserDatabase(IParameterizedUser user, String user_password);
    boolean checkDuplicateEmployeeID(String employeeID);
}
