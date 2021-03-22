package login;
import database.*;
import login.Interfaces.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PersistenceUserRegistrationOperations implements IPersistenceUserRegistrationOperations
{
    private boolean result=false;
    private final IConnectionManager connection;
    public PersistenceUserRegistrationOperations(IConnectionManager connection)
    {
        this.connection = connection;
    }

    public boolean registerUserDatabase(IParameterizedUser user, String user_password)
    {
    	Connection dummyConnection=null;
        CallableStatement procedureCall;
        try {
        	String procedureName = "registerUser";
        	dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?,?,?,?,?,?)}");
            procedureCall.setString(1,user.getEmployeeID());
            procedureCall.setString(2,user.getfirstName());
            procedureCall.setString(3,user.getLastName());
            procedureCall.setString(4, user.getEmail());
            procedureCall.setString(5, user_password);
            procedureCall.setString(6, user.getUserType());
            return executeUpdateCommand(procedureCall);
        }
        catch (SQLException throwables)
        {
            result = false;
            return result;
        }
        finally
        {
            connection.closeConnection();
        }
    }

    public boolean checkDuplicateEmployeeID(String employeeID)
    {
        CallableStatement procedureCall;
        try
        {
            procedureCall = connection.establishConnection().prepareCall("{call getEmployeeDetails(?)}");
            procedureCall.setString(1,employeeID);
            if(executeCommand(procedureCall))
            {
                ResultSet resultSet = procedureCall.getResultSet();
                if(resultSet.next())
                {
                    return result = true;
                }
                else
                {
                    return result = false;
                }
            }
        }
        catch (SQLException throwables)
        {
            result = false;
            return result;
        }
        finally
        {
            connection.closeConnection();
        }
        return result = false;
    }

    boolean executeCommand(CallableStatement procedureCall)
    {
        boolean result;
        try
        {
            result = procedureCall.execute();
            return result;
        }
        catch (SQLException throwables)
        {
            result = false;
            return result;
        }
    }

    boolean executeUpdateCommand(CallableStatement procedureCall)
    {
        boolean result;
        int updateResult;
        try{
            updateResult = procedureCall.executeUpdate();
            if(updateResult==1)
            {
                result = true;
                return result;
            }
            result = false;
            return result;
        }
        catch (SQLException throwables)
        {
            result = false;
            return result;
        }
    }
}
