package login;
import database.*;
import login.Interfaces.IPersistenceForgotPasswordOperations;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PersistenceForgotPasswordOperations implements IPersistenceForgotPasswordOperations
{
    private String configurationFile = "ConfigurationFile.txt";
    IConnectionManager connection = new ConnectionManager(configurationFile);
    IDatabaseOperations databaseOperations = new DatabaseOperations();

    public String getEmail(String employeeID)
    {
        Connection dummyConnection=null;
        CallableStatement procedureCall;
        String email = "";

        try {
            String procedureName = "getEmail";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?)}");
            procedureCall.setString(1, employeeID);
            ResultSet resultSet = procedureCall.executeQuery();
            while(resultSet.next())
            {
                email = resultSet.getString("email");
            }
            return email;
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

    public boolean updatePassword(String employeeID, String newPassword)
    {
        Connection dummyConnection=null;
        CallableStatement procedureCall;

        try {
            String procedureName = "updatePassword";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?,?)}");
            procedureCall.setString(1, employeeID);
            procedureCall.setString(1, newPassword);
            return databaseOperations.executeUpdateCommand(procedureCall);
        }
        catch (SQLException throwables)
        {
            return false;
        }
        finally
        {
            connection.closeConnection();
        }
    }
}
