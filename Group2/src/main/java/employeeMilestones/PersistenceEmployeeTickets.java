package employeeMilestones;
import database.ConnectionManager;
import database.IConnectionManager;
import employeeMilestones.abstractfactory.*;
import employeeMilestones.interfaces.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PersistenceEmployeeTickets implements IPersistenceEmployeeTickets
{
    private final IEmployeeMilestoneFactory employeeMilestoneFactory = EmployeeMilestoneFactory.instance();
    private final String configurationFile = "ConfigurationFile.txt";
    private final IConnectionManager connection = new ConnectionManager(configurationFile);

    public List<IParameterizedEmployeeTicket> getEmployeeTickets(String employeeID)
    {
        String ticketID;
        String customerID;
        String ticketType;
        Date startDate;
        Date endDate;
        int rating;
        int priority;
        int impact;
        int urgency;
        List<IParameterizedEmployeeTicket> employeeTicketList = new ArrayList<>();

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
                priority = resultSet.getInt("priority");
                impact = resultSet.getInt("impact");
                urgency = resultSet.getInt("urgency");
                ticketType = resultSet.getString("ticketType");
                IParameterizedEmployeeTicket employeeTicket = employeeMilestoneFactory.getParameterizedEmployeeTicket(ticketID, employeeID, customerID, startDate, endDate, rating, priority, impact, urgency, ticketType);
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