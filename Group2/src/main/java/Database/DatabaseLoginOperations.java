package database;
import database.IConnectionManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DatabaseLoginOperations implements IDatabaseLoginOperations
{
    private final int one = 1;
    private final int two = 2;
    private final int three = 3;
    private final int four = 4;
    private final int five = 5;
    private final int six = 6;
    private boolean result=false;

    @Override
    public boolean registerUserDatabase(String employeeID, String firstName, String lastName, String email, String user_password, String user_type, IConnectionManager connection)
    {
        CallableStatement procedureCall;
        try {
            procedureCall = connection.establishConnection().prepareCall("call registerUser(?,?,?,?,?,?)");
            procedureCall.setString(one,employeeID);
            procedureCall.setString(two,firstName);
            procedureCall.setString(three,lastName);
            procedureCall.setString(four, email);
            procedureCall.setString(five, user_password);
            procedureCall.setString(six, user_type);
            return executeCommand(procedureCall);
        }
        catch (SQLException throwables)
        {
            System.out.println("Unbale to register new user.");
            result = false;
            return result;
        }
    }

    @Override
    public boolean checkDuplicateEmployeeID(String employeeID, IConnectionManager connection)
    {
        CallableStatement procedureCall;

        try
        {
            procedureCall = connection.establishConnection().prepareCall("call getEmployeeDetails(?)");
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
            System.out.println("Unbale to register new user.");
            result = false;
            return result;
        }
        return result = false;
    }

    private boolean executeCommand(CallableStatement procedureCall)
    {
        try{
            result = procedureCall.execute();
            return result;
        }
        catch (SQLException throwables)
        {
            System.out.println("Unbale to register new user.");
            result = false;
            return result;
        }
    }
}
