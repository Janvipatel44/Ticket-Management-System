package employeeMilestones.abstractFactory;
import employeeMilestones.PersistenceEmployeeTicketsMock;
import employeeMilestones.interfaces.IPersistenceEmployeeTickets;
public class EmployeeMilestoneFactoryTestImplementation extends EmployeeMilestoneFactoryTest
{
    public IPersistenceEmployeeTickets getPersistenceEmployeeTicketsMock()
    {
        return new PersistenceEmployeeTicketsMock();
    }
}

