package employeeMilestones.abstractFactory;
import employeeMilestones.*;
import employeeMilestones.interfaces.*;
import java.sql.Date;
import java.util.List;
public class EmployeeMilestoneFactoryImplementation extends EmployeeMilestoneFactory
{
    public ICalculateMilestone getCalculateMilestone(List<IParameterizedEmployeeTicket> employeeTicketList)
    {
        return new CalculateMilestone(employeeTicketList);
    }

    public IEmployeeMilestone getEmployeeMilestone()
    {
        return new EmployeeMilestone();
    }

    public IParameterizedEmployeeTicket getParameterizedEmployeeTicket(String ticketID, String employeeID, String customerID, Date startDate, Date endDate, int rating, int priority, int impact, int urgency, String ticketType)
    {
        return new ParameterizedEmployeeTicket(ticketID, employeeID, customerID, startDate, endDate, rating, priority, impact, urgency, ticketType);
    }

    public IPersistenceEmployeeTickets getPersistenceEmployeeTickets()
    {
        return new PersistenceEmployeeTickets();
    }
}
