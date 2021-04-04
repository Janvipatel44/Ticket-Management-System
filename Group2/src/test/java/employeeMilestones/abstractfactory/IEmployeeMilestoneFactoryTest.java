package employeeMilestones.abstractfactory;
import employeeMilestones.interfaces.IEmployeeMilestone;
import employeeMilestones.interfaces.IPersistenceEmployeeTickets;
public interface IEmployeeMilestoneFactoryTest
{
    IPersistenceEmployeeTickets getPersistenceEmployeeTicketsMock();
    IEmployeeMilestone getEmployeeMilestone();
}
