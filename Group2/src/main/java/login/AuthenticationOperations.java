package login;
import database.IConnectionManager;
import login.Interfaces.*;
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
        final Object nullObject = null;
        String procedureName = "getPassword";
        Connection dummyConnection=null;
        CallableStatement procedureCall;
        try {
            dummyConnection = connection.establishConnection();
            procedureCall =	dummyConnection.prepareCall("{call "+procedureName+"(?,?)}");
            procedureCall.setString(1,employeeID);
            procedureCall.registerOutParameter(2, Types.VARCHAR);
            procedureCall.execute();
            String result=procedureCall.getString(2);
            if(result.equals(nullObject))
            {
            	return null;
            }
            else 
            {
            	return result;
            }
        }
        catch (SQLException throwables)
        {
            return null;
        }
        finally
        {
            connection.closeConnection();
        }
    }
}