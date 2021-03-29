package login;

import login.Interfaces.IAuthenticationOperations;

public class AuthenticationOperationsMock implements IAuthenticationOperations {

    public String getPassword(String employeeID) {
        return "AcegD68:";
    }
}
