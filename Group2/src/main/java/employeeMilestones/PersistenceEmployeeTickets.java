package employeeMilestones;
import database.IConnectionManager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class PersistenceEmployeeTickets
{
    IConnectionManager connection;
    PersistenceEmployeeTickets(IConnectionManager connection)
    {
        this.connection = connection;
    }

    List<IEmployeeTicket> getEmployeeTickets(String employeeID)
    {
        Connection dummyConnection=null;
        CallableStatement procedureCall;
        try {
            String procedureName = "ticketsByEmployee";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?)}");
            procedureCall.setString(1, employeeID);

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
}
