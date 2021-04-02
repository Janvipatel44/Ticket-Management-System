package database;
import com.group2.userinterface.IInputOutputHandler;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
public class AuthenticationOperations implements IAuthenticationOperations
{
    private final IConnectionManager connection;
    private final IInputOutputHandler inputOutputHandler;

    public AuthenticationOperations(IConnectionManager connection, IInputOutputHandler inputOutputHandler)
    {
        this.connection = connection;
        this.inputOutputHandler = inputOutputHandler;
    }
    public boolean authenticateUser(String employeeID, String user_password)
    {
        boolean successfulAuthentication;
        final int one = 1;
        final int two = 2;
        CallableStatement procedureCall;
        try {
            procedureCall = connection.establishConnection().prepareCall("{call authenticateUser(?,?)}");
            procedureCall.setString(one,employeeID);
            procedureCall.registerOutParameter(two, Types.VARCHAR);
            procedureCall.execute();
            String result=procedureCall.getString(two);
            if(result.equals(user_password))
            {
                successfulAuthentication =true;
                return successfulAuthentication;
            }
            else
            {
                successfulAuthentication = false;
                return successfulAuthentication;
            }
        }
        catch (SQLException throwables)
        {
            inputOutputHandler.displayMethod("Error: Unbale to register new user.");
            successfulAuthentication = false;
            return successfulAuthentication;
        }
    }
}