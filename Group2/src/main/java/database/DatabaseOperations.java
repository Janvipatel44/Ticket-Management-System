package database;
import database.intefaces.IDatabaseOperations;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DatabaseOperations implements IDatabaseOperations
{
    public boolean executeCommand(CallableStatement procedureCall)
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

    public boolean executeUpdateCommand(CallableStatement procedureCall)
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

    public ResultSet executeQuery(CallableStatement procedureCall)
    {
        try
        {
            return procedureCall.executeQuery();
        }
        catch (SQLException throwables)
        {
            return null;
        }
    }
}
