package login;
import database.IConnectionManager;
import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import login.Interfaces.*;
import login.abstractfactory.ILoginFactory;
import login.abstractfactory.LoginFactory;

import java.sql.*;

public class PersistenceAuthenticationOperations implements IPersistenceAuthenticationOperations
{
    ILoginFactory loginFactory = LoginFactory.instance();
    private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
    private String configurationFile = "ConfigurationFile.txt";
    private final IConnectionManager connection = databaseFactory.getConnectionManager(configurationFile);

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

    public IParameterizedUser getUserDetails(String employeeID)
    {
        IParameterizedUser parameterizedUser;
        String firstName;
        String lastName;
        String userType;
        String email;
        final Object nullObject = null;
        String procedureName = "getUserDetails";
        Connection dummyConnection=null;
        CallableStatement procedureCall;

        try {
            dummyConnection = connection.establishConnection();
            procedureCall =	dummyConnection.prepareCall("{call "+procedureName+"(?)}");
            procedureCall.setString(1,employeeID);
            ResultSet resultSet = procedureCall.executeQuery();
            if(resultSet.next())
            {
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("email");
                userType = resultSet.getString("user_type");
                parameterizedUser = loginFactory.getParameterizedUser(employeeID, firstName, lastName, email, userType);
                return parameterizedUser;
            }
            else
            {
                return null;
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