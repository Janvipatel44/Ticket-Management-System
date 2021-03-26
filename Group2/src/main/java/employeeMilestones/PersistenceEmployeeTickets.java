package employeeMilestones;
import database.IConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PersistenceEmployeeTickets implements  IPersistenceEmployeeTickets
{
    private final IConnectionManager connection;
    PersistenceEmployeeTickets(IConnectionManager connection)
    {
        this.connection = connection;
    }

    public List<IEmployeeTicket> getEmployeeTickets(String employeeID)
    {
        String ticketID;
        String customerID;
        Date startDate;
        Date endDate;
        int rating;
        List<IEmployeeTicket> employeeTicketList = new ArrayList<>();

        Connection dummyConnection;
        CallableStatement procedureCall;
        try {
            String procedureName = "ticketsByEmployee";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?)}");
            procedureCall.setString(1, employeeID);
            ResultSet resultSet = procedureCall.executeQuery();
            while(resultSet.next())
            {
                ticketID = resultSet.getString("tiketId");
                customerID = resultSet.getString("customerID");
                startDate = resultSet.getDate("startDate");
                endDate = resultSet.getDate("endDate");
                rating = resultSet.getInt("rating");
                IEmployeeTicket employeeTicket = new EmployeeTicket(ticketID, employeeID, customerID, startDate, endDate, rating);
                employeeTicketList.add(employeeTicket);
            }

            return employeeTicketList;
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