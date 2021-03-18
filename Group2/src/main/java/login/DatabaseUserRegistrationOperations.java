<<<<<<< HEAD:Group2/src/main/java/login/DatabaseUserRegistrationOperations.java
package login;
import database.*;
=======
package database;
>>>>>>> 1e4b70c55d45bf67f1e1a37d6da192802147005b:Group2/src/main/java/Database/DatabaseUserRegistrationOperations.java
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import userinterface.IInputOutputHandler;
public class DatabaseUserRegistrationOperations implements IDatabaseUserRegistrationOperations
{
    private final int one = 1;
    private final int two = 2;
    private final int three = 3;
    private final int four = 4;
    private final int five = 5;
    private final int six = 6;
    private boolean result=false;
    private final IConnectionManager connection;

    public DatabaseUserRegistrationOperations(IConnectionManager connection)
    {
        this.connection = connection;
    }

    public boolean registerUserDatabase(User user, String user_password)
    {
    	Connection dummyConnection=null;
        CallableStatement procedureCall;
        try {
        	String procedureName = "registerUser";
        	dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?,?,?,?,?,?)}");
            procedureCall.setString(one,user.getEmployeeID());
            procedureCall.setString(two,user.getfirstName());
            procedureCall.setString(three,user.getLastName());
            procedureCall.setString(four, user.getEmail());
            procedureCall.setString(five, user_password);
            procedureCall.setString(six, user.getUserType());
            return executeUpdateCommand(procedureCall);
        }
        catch (SQLException throwables)
        {
            result = false;
            return result;
        }
    }

    public boolean checkDuplicateEmployeeID(String employeeID)
    {
        CallableStatement procedureCall;
        try
        {
            procedureCall = connection.establishConnection().prepareCall("{call getEmployeeDetails(?)}");
            procedureCall.setString(one,employeeID);
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
        return result = false;
    }

    private boolean executeCommand(CallableStatement procedureCall)
    {
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

    private boolean executeUpdateCommand(CallableStatement procedureCall)
    {
        int updateResult;
        try{
            updateResult = procedureCall.executeUpdate();
            if(updateResult==one)
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
