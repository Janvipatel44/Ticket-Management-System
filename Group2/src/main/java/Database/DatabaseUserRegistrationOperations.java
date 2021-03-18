package database;
import java.sql.CallableStatement;
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
    private final IInputOutputHandler inputOutputHandler;

    public DatabaseUserRegistrationOperations(IConnectionManager connection, IInputOutputHandler inputOutputHandler)
    {
        this.connection = connection;
        this.inputOutputHandler = inputOutputHandler;
    }

    public boolean registerUserDatabase(String employeeID, String firstName, String lastName, String email, String user_password, String user_type)
    {
        CallableStatement procedureCall;
        try {
            procedureCall = connection.establishConnection().prepareCall("{call registerUser(?,?,?,?,?,?)}");
            procedureCall.setString(one,employeeID);
            procedureCall.setString(two,firstName);
            procedureCall.setString(three,lastName);
            procedureCall.setString(four, email);
            procedureCall.setString(five, user_password);
            procedureCall.setString(six, user_type);
            return executeUpdateCommand(procedureCall);
        }
        catch (SQLException throwables)
        {
            inputOutputHandler.displayMethod("Error: Unbale to register new user.");
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
            inputOutputHandler.displayMethod("Error: Unbale to register new user.");
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
            inputOutputHandler.displayMethod("Unbale to register new user.");
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
            inputOutputHandler.displayMethod("Unbale to register new user.");
            result = false;
            return result;
        }
    }
}
