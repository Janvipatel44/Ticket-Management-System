package employeeMilestones.abstractfactory;
import employeeMilestones.interfaces.*;
import java.sql.Date;
import java.util.List;
public interface IEmployeeMilestoneFactory
{
    ICalculateMilestone getCalculateMilestone(List<IParameterizedEmployeeTicket> employeeTicketList);
    IEmployeeMilestone getEmployeeMilestone();
    IParameterizedEmployeeTicket getParameterizedEmployeeTicket(String ticketID, String employeeID, String customerID, Date startDate, Date endDate, int rating, int priority, int impact, int urgency, String ticketType);
    IPersistenceEmployeeTickets getPersistenceEmployeeTickets();
}
