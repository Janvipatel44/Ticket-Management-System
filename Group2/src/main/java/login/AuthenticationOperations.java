package login;
import database.IConnectionManager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
public class AuthenticationOperations implements IAuthenticationOperations
{
    private final IConnectionManager connection;

    public AuthenticationOperations(IConnectionManager connection)
    {
        this.connection = connection;
    }
    public String getPassword(String employeeID)
    {
        final int one = 1;
        final int two = 2;
        final String failedMessage = "Error: Unable to fetch password from database. Please try again.";
        final String userNotFound = "Error: User does not exist.";
        final Object nullObject = null;
        String procedureName = "getPassword";
        Connection dummyConnection=null;
        CallableStatement procedureCall;
        try {
            dummyConnection = connection.establishConnection();
            procedureCall =	dummyConnection.prepareCall("{call "+procedureName+"(?,?)}");
            procedureCall.setString(one,employeeID);
            procedureCall.registerOutParameter(two, Types.VARCHAR);
            procedureCall.execute();
            String result=procedureCall.getString(two);
            if(result.equals(nullObject))
            {
            	return userNotFound;
            }
            else 
            {
            	return result;
            }
        }
        catch (SQLException throwables)
        {
            return failedMessage;
        }
    }
}