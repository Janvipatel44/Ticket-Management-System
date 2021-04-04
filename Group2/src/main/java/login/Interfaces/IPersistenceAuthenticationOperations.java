package login.Interfaces;
public interface IPersistenceAuthenticationOperations
{
    String getPassword(String employeeID);
    IParameterizedUser getUserDetails(String employeeID);
}
