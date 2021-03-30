package employeeMilestones.abstractFactory;
import employeeMilestones.interfaces.*;

import java.sql.Date;
import java.util.List;

public abstract class EmployeeMilestoneFactory
{
    public abstract ICalculateMilestone getCalculateMilestone(List<IParameterizedEmployeeTicket> employeeTicketList);
    public abstract IEmployeeMilestone getEmployeeMilestone();
    public abstract IParameterizedEmployeeTicket getParameterizedEmployeeTicket(String ticketID, String employeeID, String customerID, Date startDate, Date endDate, int rating, int priority, int impact, int urgency, String ticketType);
    public abstract IPersistenceEmployeeTickets getPersistenceEmployeeTickets();
}
