package Rating;
import database.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
public class PersistenceRating implements IPersistenceRating
{
    IConnectionManager connection;
    IDatabaseOperations databaseOperations;

    public PersistenceRating(IConnectionManager connection, IDatabaseOperations databaseOperations)
    {
        this.connection = connection;
        this.databaseOperations = databaseOperations;
    }

    public String getPersistenceCreatorID(String ticketID)
    {
        Connection dummyConnection=null;
        CallableStatement procedureCall;
        try {
            String procedureName = "checkCreator";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?,?}");
            procedureCall.setString(1, ticketID);
            procedureCall.registerOutParameter(2, Types.VARCHAR);
            if(databaseOperations.executeCommand(procedureCall))
            {
                return procedureCall.getString(2);
            }
            return null;
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

    public boolean insertRating(String ticketID, int rating)
    {
        Connection dummyConnection=null;
        CallableStatement procedureCall;
        try
        {
            String procedureName = "insertRating";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?,?}");
            procedureCall.setString(1, ticketID);
            procedureCall.setInt(2, rating);
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
